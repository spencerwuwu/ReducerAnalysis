//https://searchcode.com/file/64792685/java/hadoop/src/PatentHistogram.java#l-15

package reduce_test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.hadoop.io.IntWritable;

public class context0_90_6_14 implements ReducerC<IntWritable, IntWritable>{

	public static void main(String[] args){
		for(int i=0; i<Common.maxcount ; i++){  
			ReducerC<IntWritable, IntWritable> reducer=new context0_90_6_14();
			Tester<IntWritable, IntWritable, IntWritable, IntWritable> tester=new Tester<IntWritable, IntWritable, IntWritable, IntWritable>();
			IntWritable[] solutionArray = { new IntWritable(1), new IntWritable(2), new IntWritable(3) };
			try {
				tester.test(new IntWritable(1), solutionArray, reducer);
			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void reduce(IntWritable key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int count = 0;
		for (IntWritable value : values) {
			count += value.get();
		}
		context.write(key, new IntWritable(count));
	}


}
