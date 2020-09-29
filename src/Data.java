
/**
 * Date: 2020-09-29
 * @author chinsung
 */
public class Data {
	public String url;
	public String sel;
	public String interval;
	public long length;

	public Data() {
	}
	
	/**
	 * @param url address url to parse
	 * @param sel html Selector
	 * @param interval parsing interval
	 * @param length Number of html characters in a select query html object
	 */
	public Data(Object url,Object sel, Object interval, Object length) {
		this.url = (String) url;
		this.sel = (String) sel;
		this.interval = (String) interval;
		this.length = (long) length;
	}
}
