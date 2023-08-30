//문제 3 : 02-03
//두 개의 정수를 입력받아서 다음과 같은 출력결과를 만들어보자.
//출력예) 두개의 정수를 입력하세요.
//25    4 
//25 나누기 4 의 몫은 6 입니다.
//25 나누기 4 의 나머지는 1 입니다.

package quiz;

import java.util.Scanner;

public class Quiz02_03
{

	public static void main(String[] args)
	{
		System.out.print("첫번째 정수를 입력:");
		Scanner sc = new Scanner(System.in);
		try
		{
			int a = sc.nextInt();
			System.out.print("두번째 정수를 입력:");
			int b = sc.nextInt();
			System.out.printf("%d    %d \n", a, b);
			System.out.printf("%d 나누기 %d 의 몫은 %d\n", a, b, a / b);
			System.out.printf("%d 나누기 %d 의 나머지는 %d", a, b, a % b);
			sc.close();
		} catch (Exception e)
		{
			System.out.println("정수를 입력하세요");
		}
	}

}
