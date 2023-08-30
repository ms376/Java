
public class Ex11_PartiallyFilled
{

	public static void main(String[] args)
	{
		int[][] arr =
		{
				{ 11 },
				{ 22, 33 },
				{ 44, 55, 66 } };
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		// 2차원 배열에서 특정 원소에 접급하려면 2개의 배열기호가 필요.
		// null을 부르면 예외 발생(배열 크기초과 예외발생)
		System.out.println("배열 출력");
		System.out.println("arr[0][0]="+arr[0][0]);
		
		//예외
//		System.out.println("arr[0][1]="+arr[0][1]);
	}
}
