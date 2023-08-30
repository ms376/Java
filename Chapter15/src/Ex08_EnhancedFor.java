
public class Ex08_EnhancedFor
{

	public static void main(String[] args)
	{
		int[] arr =
		{ 1, 2, 3, 4, 5 };

		for (int e : arr)
		{
			System.out.print(e + " ");
		}
		System.out.println();

		int sum = 0;
		for (int e : arr)
		{
			sum = sum + e;

		}
		System.out.println("sum " + sum);

		System.out.println("배열 arr의 요소값 1증가시키기");
		for (int b : arr)
		{
			b++;
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println("배열 arr의 요소 재출력하기");
		for (int c : arr)
		{
			System.out.print(c + " ");
		}
	}
}
