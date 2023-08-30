//문제 06-01
//두 개의 정수를 입력 받아서 두 수의 차를 출력하는 프로그램을 작성하라.
//단 입력된 두 수의 순서에 상관없이 출력결과는 항상 0 이상이어야 한다.
//1과2를 입력했다면 1 .... 20과10을 입력했다면 10 ....

package quiz;

import java.util.Scanner;

public class Quiz06_01
{

	public static void main(String[] args)
	{
		System.out.print("첫번째 정수를 입력:");
		Scanner sc = new Scanner(System.in);
		try
		{
			int max = 0;
			int min = 0;
			int a = sc.nextInt();
			System.out.print("두번째 정수를 입력:");
			int b = sc.nextInt();
			if (a > b)
				max = a;
			min = b;
			if (a <= b)
				max = b;
			min = a;
			System.out.printf("값은 %d", max - min);
			sc.close();
		} catch (Exception e)
		{
			System.out.println("정수를 입력하세요");
		}

	}

}
