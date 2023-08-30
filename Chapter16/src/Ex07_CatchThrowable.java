import java.util.Scanner;

public class Ex07_CatchThrowable

{
	public static void MyMethod1()
	{
		MyMethod2();
	}

	public static void MyMethod2()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			int num1 = sc.nextInt();
			int num2 = 10 / num1;
			System.out.println(num2);
		} catch (Exception e)
		{
			System.out.println("0ㄴㄴ");
		}
	}

	public static void main(String[] args)
	{
		try
		{
			MyMethod1();
		} catch (Throwable e)
		{
			e.printStackTrace();
//		System.out.println(e.getMessage());
//			System.out.println("에러");
		}
	}

}
