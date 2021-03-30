//package mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanDataMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		
		// 分词
		String[] word = line.split(",");
		
		// 包含6个字段，并且url开头为http的日志为正确的日志
		if (word.length ==6 && word[2].startsWith("http")) {
			context.write(value, NullWritable.get());
		}
	}
}
