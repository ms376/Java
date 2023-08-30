import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04_CatchConcat
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			int num1 = sc.nextInt();
			int num2 = 10 / num1;
			System.out.println(num2);

		} catch (ArithmeticException | InputMismatchException e) // 0일때 실행.
		{
//			String str = e.getMessage(); //간략한 설명.
//			System.out.println(str);
//			if (str.equals("/ by zero"))
			System.out.println("오입력."); // 내가만든메세지
			System.out.println(" Good bye");
		}
		sc.close();

	}

}
