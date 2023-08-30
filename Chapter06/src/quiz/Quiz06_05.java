//문제 06-05
//사용자로부터 계속해서 정수를 입력받는다.
//단 0을 입력받게되면 기존에 입력받은 모든 정수를 더한 후 결과를 출력하시오.

package quiz;

import java.util.Scanner;

public class Quiz06_05
{

	public static void main(String[] args)
	{
		System.out.println("정수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		try
		{
			int a = sc.nextInt();
			for (int i = 0; i < args.length; i++)
			{
				
			}
			System.out.println(a * a);
		} catch (Exception e)
		{
			System.out.println("문자가 아닌 정수를 입력하세요");
		}

		sc.close();
	}

}
