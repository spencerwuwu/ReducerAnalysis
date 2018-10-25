// https://searchcode.com/api/result/64576683/

/**
 * This file is part of Mardigras.
 * 
 *  Mardigras is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Mardigras is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with Mardigras. If not, see <http://www.gnu.org/licenses/>.
 *       
 * @author Matteo Camilli <matteo.camilli@unimi.it>
 *
 */

package core.ctl;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import data.State;

public class EUReducer<E extends State> extends Reducer<Text, E, Text, E> {

	@Override
	protected void reduce(Text key, Iterable<E> list, Context context) throws IOException, InterruptedException {
		
		/* E(true1 U true2) */
		
		boolean fakeFound = false;
		boolean stateFound = false;
		boolean true2Found = false;
		E state = null;
		//System.out.println("***** REDUCE CALL *****");
		for(E e: list){
			//System.out.println(e.getName());
			if(e.getName().equals("F")){
				fakeFound = true;
			}
			else if(e.getName().equals("T")){
				true2Found = true;
			}
			else {
				state = (E)e.clone();
				stateFound = true;
			}
				
			if(fakeFound && stateFound && true2Found)
				break;
		}
		if(stateFound){
			if(fakeFound && !true2Found) // this is a true1 state but not true2
				context.write(key, state);
		}
		
	}

}
