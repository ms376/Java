import java.util.Arrays;

public class Ex13_ArrayEquals
{

	public static void main(String[] args)
	{
		int[] arr1 =
		{ 1, 2, 3, 4, 5 };
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);

		//참조값은 다름.
		boolean bCheck = Arrays.equals(arr1, arr2);
		System.out.println(bCheck);
	}

}
