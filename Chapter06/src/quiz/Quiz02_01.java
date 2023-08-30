//문제 1 : 02-01
//사용자로부터 두 개의 정수를 입력받아서 사칙연산에 대한 결과를 출력하는 
//프로그램을 작성하라.

package quiz;

import java.util.Scanner;

public class Quiz02_01
{
	public static void add(int a, int b)
	{
		int result = a + b;
		System.out.printf("%d + %d = %d", a, b, result);
		System.out.println();
	}

	public static void min(int a, int b)
	{
		int result = a - b;
		System.out.printf("%d - %d = %d", a, b, result);
		System.out.println();
	}

	public static void mul(int a, int b)
	{
		int result = a * b;
		System.out.printf("%d * %d = %d", a, b, result);
		System.out.println();
	}

	public static void div(int a, int b)
	{
		int result1 = a / b;
		int result2 = a % b;
		System.out.printf("%d / %d = %d 몫:%d", a, b, result1, result2);
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 숫자는:");
		int a = sc.nextInt();
		System.out.println("두번째 숫자는:");
		int b = sc.nextInt();
		try
		{
			if (a <= 0 || b <= 0)
			{
				System.out.println("0이상의 숫자를 입력해.");
			}

		} catch (Exception e)
		{
			System.out.println("문자가 아닌 숫자를 입력하세요.");
		}
		add(a, b);
		min(a, b);
		mul(a, b);
		div(a, b);
		sc.close();
	}
}
