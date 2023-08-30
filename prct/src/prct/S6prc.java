package prct;
//문제3) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.

//파일명 : QuPyramid03.java
//실행결과]
//     * 		0>5 *>1   	i=1 > a=5 b=1  b= b-i   	
//    ***		0>4 *>3		i=2 > a=4 b=3 
//   *****		0>3 *>5		i=3 > a=3 b=5 
//  *******		0>2 *>7		i=4 > a=2 b=7 
// *********	0>1 *>9		i=5 > a=1 b=9 
// i가 1일때 a 5번반복, b는 1번반복
// i가 2일때 a 4번반복, b는 3번반복
public class S6prc
{

	public static void main(String[] args)
	{

		int num = 5;

		for (int i = 0; i < num; i++) // 행을 반복하는 부분
		{
			for (int j = 1; j <= num - i; j++) // 공백을 출력하는 부분

			{
				System.out.print(" ");
			}
			for (int k = 0; k < i * 2 + 1; k++) // *를 출력하는 부분
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

//				for (int a = 1; a < 5; a++)
//				{
//					System.out.print(" ");
//				}
//				for (int b = 5; b >= 0; b--)
//				{
//					System.out.print("*");
//				}
//				int a = 1, b = 5;
//				if (a >= 5)
//				{
//					System.out.print(" ");
//				}
//				if (b <= 5)
//				{
//					System.out.print("*");
//				}