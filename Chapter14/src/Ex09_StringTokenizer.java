import java.util.StringTokenizer;

public class Ex09_StringTokenizer
{

	public static void main(String[] args)
	{
		StringTokenizer st1 = new StringTokenizer("a,b,c");

		while (st1.hasMoreElements())
		{
			System.out.println(st1.nextToken());
		}
	}

}
