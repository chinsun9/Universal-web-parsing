import org.json.simple.JSONObject;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Main method
 * This app periodically parses the desired web page using quartz
 * Use the selector to check the contents changed.
 * @author chinsung
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		String filePath = "config.json";

		JSONObject jsonObject = ReadData.readJsonFile(filePath);
		Data data = new Data(jsonObject.get("url"), jsonObject.get("sel"), jsonObject.get("interval"),
				jsonObject.get("length"));

		System.out.println(data.interval);

		try {
			JobDetail job = JobBuilder.newJob(WebParsing.class).withIdentity("WebParsing", "groupWebParsing").build();
			job.getJobDataMap().put("url", data.url);
			job.getJobDataMap().put("sel", data.sel);
			job.getJobDataMap().put("length", data.length);

			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "groupWebParsing")
					.withSchedule(CronScheduleBuilder.cronSchedule(data.interval)).build();

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
