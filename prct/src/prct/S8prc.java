
//두개의 정수를 입력받아서 사칙연산의 결과를 출력하는 메소드와 
//main메소드를 작성해보자. 단
//나눗셈은 몫과 나머지를 각각 출력해야 한다.
//인수(파라메타)로 전달되는 두 숫자는 모두 0 이상의 양의 정수이다.

//		 실행결과

//	덧셈결과 -> 177
//	뺄셈결과 -> 23
//	곱셈결과 -> 7700
//	나눗셈 몫 -> 1
//	나눗셈 나머지 -> 23

package prct;

import java.util.Scanner;

public class S8prc
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
		add (a, b);
		min (a, b);
		mul (a, b);
		div (a, b);
		sc.close();
	}
}
