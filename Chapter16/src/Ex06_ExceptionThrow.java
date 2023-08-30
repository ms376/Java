
public class Ex06_ExceptionThrow
{
	public static void MyMethod1(int n)
	{
		MyMethod2(n, 0);
	}

	public static void MyMethod2(int n1, int n2)
	{
		try
		{
			int r = n1 / n2;
			
		} catch (Exception e)
		{
			System.out.println("예외발생");
		}
	}

	public static void main(String[] args)
	{
		MyMethod1(3);
		System.out.println("Exception Throw!!!");

	}

}
