import java.io.IOException;
import java.time.LocalDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author chinsung
 */
public class WebParsing implements Job {
	static String url;
	static String sel;
	static long length;

	public static void run() {
		String res = parseWeb();

		if (length != res.length()) {
			System.out.println(LocalDateTime.now() + "] changed!" + res.length());
			System.out.println(res);

			notice();

		} else {
			System.out.println(LocalDateTime.now() + "] not changed..");
		}
	}

	public static void notice() {
		System.out.println("WebParsing.notice()");
		
	}

	public static String parseWeb() {
		String ua = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36";

		Document res = null;
		try {
			res = Jsoup.connect(url).header("User-Agent", ua).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String a = res.select(sel).html();

		return a;
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
		url = (String) dataMap.get("url");
		sel = (String) dataMap.get("sel");
		length = (long) dataMap.get("length");

		run();
	}
}
