//문제 06-04
//Do~While문을 이용하여 1~1000까지 더해서 결과를 출력하는 프로그램을 작성하시오.
//실행결과도 아래와같이 출력하시오.
//예)1+2+3.......+1000 = 500500

package quiz;

public class Quiz06_04
{

	public static void main(String[] args)
	{
		int a = 0;
		int b = 1;
		do
		{
			a += b;
			b++;
		} while (b <= 1000);
		System.out.println("1+2+3.......+1000 = " + a);
	}

}
