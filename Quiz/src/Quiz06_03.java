//문제 06-03
//정수 하나를 입력받은 후 그 수의 팩토리얼 함수의 결과 를 
//출력하는 프로그램을 while문을 이용하여 구현하시오. 
//출력예) 
//입력정수 : 5 
//5*4*3*2*1 = 120



import java.util.Scanner;

public class Quiz06_03
{

	public static void main(String[] args)
	{
		System.out.print("팩토리얼 계산을 할 정수 입력:");
		Scanner sc = new Scanner(System.in);
		try
		{
			int a = sc.nextInt();
			while (a > 0)
			{
				int b = 0;
				int result = 0;
				b = (a - 1) * a;
				while (a > 0)
				{
					result = b;
					System.out.println(b);
					a--;
				}
				if (b < 0)
					break;
			}
			sc.close();
		} catch (Exception e)
		{
			System.out.println("정수를 입력하세요");
		}

	}

}