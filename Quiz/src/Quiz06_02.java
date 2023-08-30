//문제 06-02
//학생 한 명의 전체 평균점수에 대한 학점을 출력하는 프로그램을 작성하라.
//실행시 국어, 영어, 수학의 점수를 차례로 입력받은 후 평균을 구한 후
//90점이상 A, 80점이상 B, 70점이상 C, 50점이상 D, 그 미만이면 F를 출력한다.



import java.util.Scanner;

public class Quiz06_02
{

	public static void main(String[] args)
	{
		{
			System.out.print("국어 점수를 입력:");
			Scanner sc = new Scanner(System.in);
			try
			{
				int avr = 0;
				int a = sc.nextInt();
				System.out.print("영어 점수를 입력:");
				int b = sc.nextInt();
				System.out.print("수학 점수를 입력:");
				int c = sc.nextInt();
				avr = (a + b + c) / 3;
				if (avr >= 90 && avr < 101)
					System.out.println("A");
				if (avr >= 80 && avr < 90)
					System.out.println("B");
				if (avr >= 70 && avr < 80)
					System.out.println("C");
				if (avr >= 50 && avr < 70)
					System.out.println("D");
				if (avr < 50)
					System.out.println("F");
				sc.close();
			} catch (Exception e)
			{
				System.out.println("점수를 문자로 입력하세요");
			}
		}
	}
}