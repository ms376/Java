//문제 2 : 02-02
//하나의 정수를 입력받아서 그 수의 제곱을 출력하는 프로그램을 작성하라. 
//가령 5를 입력받았다면 25가 출력되어야 한다.



import java.util.Scanner;

public class Quiz02_02
{

	public static void main(String[] args)
	{
		System.out.print("제곱을 출력할 수 를 입력:");
		Scanner sc = new Scanner(System.in);
		try
		{
			int a = sc.nextInt();
			System.out.println(a*a);
			sc.close();
		} catch (Exception e)
		{
			System.out.println("정수를 입력하세요");
		}
	}

}
