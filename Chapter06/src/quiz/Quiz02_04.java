//문제 4 : 02-04
//사용자로부터 두 개의 정수를 입력받아서 큰 값을 출력하는 프로그램을 작성하라.

package quiz;

import java.util.Scanner;

public class Quiz02_04
{

	public static void main(String[] args)
	{
		System.out.print("첫번째 정수를 입력:");
		Scanner sc = new Scanner(System.in);
		try
		{
			int max=0;
			int a = sc.nextInt();
			System.out.print("두번째 정수를 입력:");
			int b = sc.nextInt();
			if (a > b) 
                max = a;
			else
				max = b;
			System.out.printf("두 정수중 큰 값은 %d",max);
			sc.close();
		} catch (Exception e)
		{
			System.out.println("정수를 입력하세요");
		}
	}

}
