import java.util.Scanner;

public class Ex05_Exception
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			int num1 = sc.nextInt();
			int num2 = 10 / num1;
			System.out.println(num2);
		} catch (Exception e)
		{
//			Exception 은 꼭 catch문 마지막에 넣어야함
//			System.out.println(e.getMessage());
//			e.printStackTrace();
			System.out.println("예외발생");
		}
		System.out.println("Good bye");

		sc.close();
	}
}
