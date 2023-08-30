package prct;

public class S5prc
{
//	문제1) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
//	파일명 : QuPyramid01.java

//	실행결과
//		*****
//		****
//		***
//		**
//		*
	public static void main(String[] args)
	{
//		a=행 b=열
		int a = 1;
		while (a <= 5)
		{
			int b = 0;
			// a의 갯수만큼 b를 반복한다.
			while (b <= 5-a)
			{
				System.out.print("*");
				b++;
			}
			System.out.println();
			a++;
		}
	}

}

//for(int i=5 ; i>=1 ; i--) { for(int j=1 ; j<=i ; j++) {
// System.out.print("*"); } System.out.println(); }