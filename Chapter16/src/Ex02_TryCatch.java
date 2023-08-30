import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02_TryCatch
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		try
		{
			int num1 = sc.nextInt();
			int num2 = 10 / num1;
			System.out.println(num2);
			System.out.println("Good bye");
			
		} catch (ArithmeticException e) // 0일때 실행.
		{
			String str = e.getMessage();
			System.out.println(str);
			if (str.equals("/ by zero"))
				System.out.println("0으로 나눌 수 없습니다."); // 내가만든메세지
		} catch (InputMismatchException e) // import 안하면 에러 정수값아니면실행
		{
//			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("숫자가아님.");  // 에러시 실행.
		}
		sc.close();

	}

}
