package statementResolver.executionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import soot.Unit;
import soot.Value;
import soot.jimple.*;
import soot.jimple.internal.*;
import statementResolver.color.Color;
import statementResolver.state.State;
import statementResolver.state.UnitSet;

public class ExecutionTree {
	private ExecutionTreeNode mRoot;
	private List<UnitSet> mUnits;
	private Map<Unit,Integer> mUnitIndexes;
	private int mEnterLoopLine = 0;
	private int mExitLoopLine = 0;
	private List<ExecutionTreeNode> mEndNodes = new ArrayList<ExecutionTreeNode>();
	private Map<String, String> mVarsType;

	private boolean mUseNextBeforeLoop = false;
	private boolean mBefore = true;
	

	public ExecutionTree(ExecutionTreeNode node, List<UnitSet> units, Map<Unit, Integer> unitIndexes, 
			int enterLoopLine, int exitLoopLine, Map<String, String> varsType, boolean before) {
		mRoot = node;
		mUnits = units;
		mUnitIndexes = unitIndexes;
		mEnterLoopLine = enterLoopLine;
		mExitLoopLine = exitLoopLine;
		mBefore = before;
		mVarsType = varsType;
	}
	
	public void addRootConstraint(String constraint) {
		mRoot.addConstraint(constraint);
	}
	
	public void executeTree() {
		List<ExecutionTreeNode> currentNodes = new ArrayList<ExecutionTreeNode>();
		List<ExecutionTreeNode> newNodes = new ArrayList<ExecutionTreeNode>();
		List<ExecutionTreeNode> endNodes = new ArrayList<ExecutionTreeNode>();
		
		currentNodes.add(mRoot);
		while (!currentNodes.isEmpty()) {
			for (ExecutionTreeNode currentNode : currentNodes) {
				executeNode(currentNode, endNodes);
				for(ExecutionTreeNode newNode: currentNode.mChildren) {
					newNodes.add(newNode);
				}
			}
			
			currentNodes.clear();
			
			for (ExecutionTreeNode node : newNodes) {
				if (mBefore) {
					if (!node.getReturnFlag() && node.getNextLine() < mEnterLoopLine) {
						currentNodes.add(node);
					} else {
						endNodes.add(node);
					}
				} else {
					if (!node.getReturnFlag() && node.getNextLine() < mExitLoopLine) {
						currentNodes.add(node);
					} else {
						endNodes.add(node);
					}
				}
			}
			newNodes.clear();
		}
		mEndNodes = endNodes;
	}
	
	public void print() {
		int index = 0;
		for (ExecutionTreeNode node : mEndNodes) {
			if (mBefore) {
				System.out.println("====== Before Loop" + String.valueOf(index + 1) + " ======");
			} else {
				System.out.println("====== After Loop" + String.valueOf(index + 1) + " ======");
			}
			if (!mBefore) detectOutput(node);
			node.getLocalVars().put("beforeLoop", "1");
			node.print();
			System.out.println("");
			index += 1;
		}
	}
	
	private void executeNode(ExecutionTreeNode currentNode, List<ExecutionTreeNode> endNodes) {
		if (!currentNode.getReturnFlag() && currentNode.getNextLine() < mUnits.size()) {
			UnitSet us = mUnits.get(currentNode.getNextLine());
			int determineUnitState = determineUnit(us.getUnit());

			if (determineUnitState == 1) {
				Unit newUnit=us.getUnit();
				State newState = new State(currentNode.getLocalVars(), currentNode.getExecutionOrder(), 
								 newUnit.toString(), us.getLine(), currentNode.getState().getInputUsedIndex());
				if (newUnit instanceof AssignStmt) {
					newState = performAssignStmt(newState, newUnit, currentNode.getLocalVars());
				} else if (newUnit instanceof IdentityStmt){
					newState = performIdentityStmt(newState, newUnit);
				}
				ExecutionTreeNode newLeaf = new ExecutionTreeNode(currentNode.getConstraint(), newState, 
						currentNode.getExecutionOrder() + 1, currentNode.getNextLine() + 1, currentNode.getReturnFlag());
				
				currentNode.mChildren.add(newLeaf);
				System.out.println( Color.ANSI_BLUE+"line '" + us.getUnit().toString() + "'" + Color.ANSI_RESET);
				System.out.println("------------------------------------");

			} else if (determineUnitState == 2) {
				Unit newUnit=us.getUnit();
				if (newUnit instanceof IfStmt) {
					State newState1 = new State(currentNode.getLocalVars(), currentNode.getExecutionOrder(),
							          newUnit.toString(), us.getLine(), currentNode.getState().getInputUsedIndex());
					State newState2 = new State(currentNode.getLocalVars(), currentNode.getExecutionOrder(), 
							          newUnit.toString(), us.getLine(), currentNode.getState().getInputUsedIndex());
					List<ExecutionTreeNode> newLeafNodes = performIfStmt(currentNode, currentNode.getConstraint(), 
							newState1, newState2, newUnit, mUnitIndexes);
					for (ExecutionTreeNode node: newLeafNodes) {
						currentNode.mChildren.add(node);
					}
					System.out.println( Color.ANSI_BLUE + "line '" + us.getUnit().toString() + "'" + Color.ANSI_RESET);
					System.out.println("Split the tree here.");
					System.out.println("------------------------------------");

				} else if (newUnit instanceof GotoStmt) {
					State newState = new State(currentNode.getLocalVars(), currentNode.getExecutionOrder(), 
							         newUnit.toString(), us.getLine(),currentNode.getState().getInputUsedIndex());
					ExecutionTreeNode newLeaf = performGotoStmt(newState, newUnit, mUnitIndexes, mUnits);
					newLeaf.setConstraint(currentNode.getConstraint());
					newLeaf.setExecutionOrder(currentNode.getExecutionOrder() + 1);
					// 'nextLine' had been set in performGotoStmt
					newLeaf.setReturnFlag(currentNode.getReturnFlag());
					System.out.println( Color.ANSI_BLUE+"line '" +us.getUnit().toString()+"'"+ Color.ANSI_RESET);
					System.out.println("------------------------------------");

				}
			} else if (determineUnitState == 3) {
				System.out.println(Color.ANSI_BLUE+"++++++++++++++++ Return +++++++++++++++++"+Color.ANSI_RESET);
				// Add this treenode to endNodes, waiting to print the result
				endNodes.add(currentNode);
				
				boolean newReturnFlag = true;
			    ExecutionTreeNode newLeaf = new ExecutionTreeNode(currentNode.getConstraint(), 
			    		currentNode.getState(), currentNode.getExecutionOrder(), currentNode.getNextLine(), newReturnFlag);
			    endNodes.add(newLeaf);

			} else if (determineUnitState == 4) {
				// Deal with specialinvoke and vritualinvoke (especially the output collector)
				System.out.println(Color.ANSI_BLUE + "line '" + us.getUnit().toString() + "'" + Color.ANSI_RESET);
				if(us.getUnit().toString().contains("specialinvoke")) {
				    ExecutionTreeNode newLeaf = performSpecialInvoke(currentNode, us);
				    if (newLeaf != null) currentNode.mChildren.add(newLeaf);
				} else if(us.getUnit().toString().contains("virtualinvoke") ) {
				    ExecutionTreeNode newLeaf = performVirtualInvoke(currentNode, us);
				    if (newLeaf != null) currentNode.mChildren.add(newLeaf);
				}

			} else {
				System.out.println(Color.ANSI_BLUE + "line '" + us.getUnit().toString() + "'" + Color.ANSI_RESET);
				ExecutionTreeNode newLeaf = new ExecutionTreeNode(currentNode.getConstraint(), currentNode.getState(),
						currentNode.getExecutionOrder(), currentNode.getNextLine() + 1, currentNode.getReturnFlag());
				currentNode.mChildren.add(newLeaf);
				System.out.println(Color.ANSI_RED + "Skip" + Color.ANSI_RESET);
			}
		}
	}

	// TODO: Far from matching all cases.
	// 0 : null
	// 1 : no unit return, eg: AssignStmt
	// 2 : going to a unit target, eg: GotoStmt
	// 3 : return
	// 4 : testing
	protected int determineUnit(Unit u) {
		if (u instanceof JLookupSwitchStmt) {
			return 0;
		}
		else if (u instanceof AssignStmt) {
			return 1;
		}
		else if (u instanceof ArrayRef) {
			return 0;
		}
		else if (u instanceof BreakpointStmt) {
			return 0;
		}
		else if (u instanceof BinopExpr) {
			return 0;
		}
		else if (u instanceof CaughtExceptionRef) {
			return 0;
		}
		else if (u instanceof GotoStmt) {
			return 2;
		}
		else if (u instanceof NoSuchLocalException) {
			return 0;
		}
		else if (u instanceof NullConstant) {
			return 0;
		}
		else if (u instanceof IfStmt) {
			return 2;
		}
		else if (u instanceof IdentityStmt) {
			return 1;
		}
		else if (u instanceof InstanceOfExpr) {
			return 0;
		}
		else if (u instanceof JExitMonitorStmt) {
			return 0;
		}
		else if (u instanceof JInvokeStmt) {
			return 4;
		}
		else if (u instanceof ReturnStmt) {
			return 3;
		}
		else if (u instanceof TableSwitchStmt) {
			return 0;
		}
		else if (u instanceof ThrowStmt) {
			return 0;
		}
		else if (u instanceof ReturnVoidStmt) {
			return 3;
		}
		return 4;
	}

	protected State performAssignStmt(State st, Unit u, Map<String,String> lastEnv) {
		//adding flag to decide if it is in loop or not
		DefinitionStmt ds = (DefinitionStmt) u;
		Value var = ds.getLeftOp();
		// TODO: Should be able to handle more common cases
		Value assignment = ds.getRightOp();
		
		String ass_s = assignment.toString();
		// Normal assignment
		if (!ass_s.contains("Iterator")) {
			// removing quotes, eg: (org.apache.hadoop.io.IntWritable) $r6 -> $r6
			ass_s = ass_s.replaceAll("\\(.*?\\)\\s+", "");

			// handle int get(), eg: virtualinvoke $r7.<org.apache.hadoop.io.IntWritable: int get()>() -> $r7
			if (ass_s.contains("get")) {
				ass_s = ass_s.split("\\s+")[1].split("\\.")[0];
			}

			// change to prefix
			String[] temp = ass_s.split(" ");
			if(temp.length == 3) {
				ass_s = "("+temp[1]+" "+temp[0]+" "+temp[2]+")";
			}
			
			// replace rhs with mLocalVars value
			for (String re_var: lastEnv.keySet()) {
				if (ass_s.contains(re_var)) {
					System.out.println("replace "+re_var+": " + lastEnv.get(re_var));
					ass_s = ass_s.replace(re_var, lastEnv.get(re_var));
				
				}
			}
			System.out.println(Color.ANSI_GREEN + "assign: " + Color.ANSI_RESET + var.toString() + " -> " + ass_s);
			st.update( var.toString() , ass_s );
		}
		else { 
			// Handling iterator relative assignments
			if (ass_s.contains("hasNext()")) {
				System.out.println(Color.ANSI_GREEN + "assign: " + Color.ANSI_RESET + var.toString() + " -> " + ass_s);
				st.update(var.toString(), "hasNext");
			} else if (ass_s.contains("next()")) {
				if(mBefore) {mUseNextBeforeLoop = true;}
				//use a new input
				mVarsType.put("input" + st.getInputUsedIndex(), "input type");
				
				ass_s = "input" + st.getInputUsedIndex();
				st.addInputUsedIndex();
				st.update(var.toString(), ass_s);
				System.out.println(Color.ANSI_GREEN + "assign: " + Color.ANSI_RESET + var.toString() + " -> " + ass_s);    
		    }	
		}
		return st;
	}

	protected State performIdentityStmt(State st, Unit u) {
		DefinitionStmt ds = (DefinitionStmt) u;
		Value var = ds.getLeftOp();
		Value assignment = ds.getRightOp();
		// Preserve only org.apache.hadoop.io.'IntWritable and marked it as parameter'
		String assignment_tail = "@parameter "+assignment.toString().split("\\.(?=[^\\.]+$)")[1]; 
		
		System.out.println(Color.ANSI_GREEN + "assign: " + Color.ANSI_RESET + var.toString() + " -> " + assignment_tail);
		st.update(var.toString(), assignment_tail);
		return st;
	}

	protected List<ExecutionTreeNode> performIfStmt(ExecutionTreeNode parent, List<String> conditionBefore, 
			State ifBranchState, State elseBranchState, Unit u, Map<Unit,Integer> unitIndexes) {
		IfStmt if_st = (IfStmt) u;
		Unit goto_target = if_st.getTargetBox().getUnit();
		Value condition = if_st.getCondition();
		ConditionExpr conditionStmt = (ConditionExpr)condition;
		
		System.out.println(Color.ANSI_GREEN + "goto " + Color.ANSI_RESET + 
				goto_target + Color.ANSI_GREEN + " when " + Color.ANSI_RESET + condition);
		
		//split the tree
		List<String> ifCondition = new ArrayList<String>();
		List<String> elseCondition = new ArrayList<String>();
		for (String s: conditionBefore) {
			ifCondition.add(s);
			elseCondition.add(s);condition.toString();
		}
		
		String newIfCondition = condition.toString();
		String newElseCondition = "! "+condition.toString();
		
		// replace with mLocalVars value
		Map<String, String> lastEnv = parent.getLocalVars();
		for (String re_var: lastEnv.keySet()) {
			if (newIfCondition.contains(re_var) && lastEnv.get(re_var)!="hasNext" ) {
				System.out.println("replace " + re_var + ": " + lastEnv.get(re_var));
				newIfCondition = newIfCondition.replace(re_var, lastEnv.get(re_var));
			
			}
			if (newElseCondition.contains(re_var) && lastEnv.get(re_var)!="hasNext" ) {
				System.out.println("replace "+re_var+": " + lastEnv.get(re_var));
				newElseCondition = newElseCondition.replace(re_var, lastEnv.get(re_var));
			
			}
		}
		ifCondition.add( newIfCondition );
		elseCondition.add( newElseCondition );
				
		ExecutionTreeNode ifBranch = new ExecutionTreeNode(ifCondition, ifBranchState, 
				parent.getExecutionOrder() + 1, unitIndexes.get(goto_target), parent.getReturnFlag());
		ExecutionTreeNode elseBranch = new ExecutionTreeNode(elseCondition, elseBranchState, 
				parent.getExecutionOrder() + 1, parent.getNextLine() + 1, parent.getReturnFlag());
		
		if(parent.getLocalVars().get(conditionStmt.getOp1().toString()) == "hasNext" ) {
			ifBranch.getLocalVars().put(conditionStmt.getOp1().toString(), "0");
			elseBranch.getLocalVars().put(conditionStmt.getOp1().toString(), "1");
		}
		ifBranch.setBranchInfo("IF branch from" + parent.getState().getCommandLineNo() );
		elseBranch.setBranchInfo("ELSE branch from" + parent.getState().getCommandLineNo() );
		
		List<ExecutionTreeNode> returnList = new ArrayList<ExecutionTreeNode>();
		returnList.add(ifBranch);
		returnList.add(elseBranch);
		return returnList;
	}

	protected ExecutionTreeNode performGotoStmt(State st, Unit u, Map<Unit,Integer> unitIndexes, List<UnitSet> units) {
		GotoStmt gt_st = (GotoStmt) u;
		Unit goto_target = gt_st.getTarget();
		ExecutionTreeNode node;
		
		if(unitIndexes.get(goto_target) > st.getCommandLineNo()) {
		    System.out.println(Color.ANSI_GREEN + "goto " + Color.ANSI_RESET + goto_target);
		    node = new ExecutionTreeNode(null, st, 0, unitIndexes.get(goto_target), false);
		}
		else {
			System.out.println(Color.ANSI_GREEN + "goto " + Color.ANSI_RESET + units.get(st.getCommandLineNo()).getUnit());
			node = new ExecutionTreeNode(null, st, 0, st.getCommandLineNo(), false);
		}
		return node;
	}

	protected ExecutionTreeNode performVirtualInvoke(ExecutionTreeNode currentNode, UnitSet us) {
		ExecutionTreeNode newLeaf = new ExecutionTreeNode(currentNode.getConstraint(), currentNode.getState(), 
											currentNode.getExecutionOrder(), currentNode.getNextLine() + 1, currentNode.getReturnFlag());
		
		if(us.getUnit().toString().contains("OutputCollector") || us.getUnit().toString().contains("Context")) {
			String value = (us.getUnit().toString().split(">")[1]).split(",")[1];
			value = value.replace(")", "");
			
			for(String replacement : currentNode.getLocalVars().keySet()) {
				if(value.contains(replacement) ) {
					System.out.println("replace " + replacement + ":" + currentNode.getLocalVars().get(replacement));
					value = value.replace(replacement, currentNode.getLocalVars().get(replacement));
				}
			}
			newLeaf.getState().update("output", value);
			return newLeaf;
		}
		return null;

	}
	
	protected ExecutionTreeNode performSpecialInvoke(ExecutionTreeNode currentNode, UnitSet us) {
		ExecutionTreeNode newLeaf = new ExecutionTreeNode(currentNode.getConstraint(), currentNode.getState(), 
											currentNode.getExecutionOrder(), currentNode.getNextLine() + 1, currentNode.getReturnFlag());
		if(us.getUnit().toString().contains("Writable") && us.getUnit().toString().contains("init")) {
			String key = (us.getUnit().toString().split("\\s+")[1]).split("\\.")[0];
			String value = us.getUnit().toString().split(">")[2];
			value = value.replace(")", "");
			value = value.replace("(", "");
			
			for(String replacement : currentNode.getLocalVars().keySet()) {
				
				if(value.contains(replacement) ) {
					
					System.out.println("replace " + replacement + ":" + currentNode.getLocalVars().get(replacement));
					value = value.replace(replacement, currentNode.getLocalVars().get(replacement));
				}
			}
			System.out.println(key + " " + value);
			newLeaf.getState().update(key, value);
			
			return newLeaf;
		}				        
		return null;
	}

	public Map<String, String> getVarType() {
		return mVarsType;
	}
	
	// Does not affect the result, just to make the Symbolic State more reasonable
	protected void detectOutput(ExecutionTreeNode node) {
		for (UnitSet us : mUnits) {
			Unit u = us.getUnit();
			if (u instanceof InvokeStmt) {
				if(u.toString().contains("virtualinvoke")) {
					if(u.toString().contains("OutputCollector") || u.toString().contains("Context")) {
						String value = (u.toString().split(">")[1]).split(",")[1];
				        value = value.replace(")", "");
                        for (String replace: node.getLocalVars().keySet()) {
				        	if(value.contains(replace) ) {
				        	    value = value.replace(replace, node.getLocalVars().get(replace));
				        	}
				        }
				        node.getLocalVars().put("output", value);
					}
				}
				else if (u.toString().contains("specialinvoke")) {
				    if (u.toString().contains("Writable") && u.toString().contains("init")) {
				    	String key = (u.toString().split("\\s+")[1]).split("\\.")[0];
				    	String type = u.toString().split(">")[1];
				        String value = u.toString().split(">")[2];
				        value = value.replace(")", "");
				        value = value.replace("(", "");
				        
				        for (String replace : node.getLocalVars().keySet()) {
				        	if(value.contains(replace) ) {
				        	    value = value.replace(replace, node.getLocalVars().get(replace));
				        	}
				        }
				        node.getLocalVars().put(key, value);    
				    }				        
				    
				}
			}
		}
	}

	public List<ExecutionTreeNode> getEndNodes() {
		return mEndNodes;
	}

}
