
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class CleanDataMain {

	public static void main(String[] args) throws Exception {
		// 1.创建任务
		Job job = Job.getInstance();
		job.setJarByClass(CleanDataMain.class);
		
		// 2.指定Mapper
		job.setMapperClass(CleanDataMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);
		
		// 3.指定文件的输入输出
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		// 4.执行
		job.waitForCompletion(true);
	}
}
