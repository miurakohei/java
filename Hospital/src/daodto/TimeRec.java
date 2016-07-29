package daodto;
import java.util.Calendar;
public class TimeRec{

	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	private String datetime;
	public TimeRec() {
	    datetime=null;
		year=0;
		month=0;
		day=0;
		hour=0;
		minute=0;
		second=0;
	}
	

	
	public String getDatetime() {
		return datetime;
	}

	public void setNow(){
		 Calendar cal1 = Calendar.getInstance();  //(1)オブジェクトの生成

		    this.year = cal1.get(Calendar.YEAR);        //(2)現在の年を取得
		    this.month = cal1.get(Calendar.MONTH) + 1;  //(3)現在の月を取得
		    this.day = cal1.get(Calendar.DATE);         //(4)現在の日を取得
		    this.hour = cal1.get(Calendar.HOUR_OF_DAY); //(5)現在の時を取得
		    this.minute = cal1.get(Calendar.MINUTE);    //(6)現在の分を取得
		    this.second = cal1.get(Calendar.SECOND);    //(7)現在の秒を取得
		    String ms = "0";
		    this.datetime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + "." + ms;
	}
}

