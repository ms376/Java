import java.util.Scanner;

public class Ex08_WhyThrow
{
	public static void MyMethod1()
	{
		try
		{
			myMethodA();
		} catch (Throwable e)
		{
			System.out.println("에러!");
		}
	}

	public static void MyMethod2()
	{
		try
		{
			myMethodA();
		} catch (Throwable e)
		{
			System.out.println("error!!");
		}
	}

	public static void myMethodA()
	{
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = 10 / num1;
		System.out.println(num2);

	}

	public static void main(String[] args)
	{
		MyMethod1();
		MyMethod2();
	}
}