
public class Ex05_for
{

	public static void main(String[] args)
	{
		for (int i = 2; i < 10; i++)
		{
			System.out.print((2 * i) + " ");
		}
		System.out.println();

		for (int i = 2; i < 10; i++)
		{
			System.out.print((3 * i) + " ");
		}
		System.out.println();
		for (int i = 2; i < 10; i++)
		{
			System.out.print((4 * i) + " ");
		}
		System.out.println();
		for (int i = 2; i < 10; i++)
		{
			System.out.print((5 * i) + " ");
		}
		System.out.println();

// ==============================================================

		for (int a = 2; a <= 9; a++)
		{
			for (int b = 1; b <= 9; b++)
			{
				int c = a * b;
				System.out.printf("%d * %d = %d ", a, b, c);
			}
			System.out.println();
		}

	}

}
