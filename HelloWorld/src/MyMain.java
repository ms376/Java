import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMain
{

	public static void main(String[] args)
	{
		Date toDayodDate = new Date();
		System.out.println("hello");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String toDayString = simple.format(toDayodDate);
		System.out.println("이전날짜" + toDayodDate);
		System.out.println("변형된날짜:" + toDayString);
	}
}
