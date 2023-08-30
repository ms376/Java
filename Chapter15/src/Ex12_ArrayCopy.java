import java.util.Arrays;

public class Ex12_ArrayCopy
{

	public static void main(String[] args)
	{
		int[] arr1 = new int[10];
//		for (int i = 0; i < arr1.length; i++)
//		{
//			System.out.print(arr1[i]+" ");
//		}
//		System.out.println();
		
		int[] arr2 = new int[8];
//		for (int i = 0; i < arr2.length; i++)
//		{
//			System.out.print(arr2[i]+" ");
//		}
//		System.out.println();

		Arrays.fill(arr1, 3);
		
		System.arraycopy(arr1, 0, arr2, 3, 4);
		// arr1 0번째부터 4개를 arr2의 3번째부터 복사함
		// arr1,n, arr2,n,   n< 몇개복사할지.

		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ");
		System.out.println();
		
		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();
		
		int[] arr3 = Arrays.copyOfRange(arr2, 2, 5);
		//arr2 에 2인덱스에서 5인덱스전까지 복사
		

		for (int i = 0; i < arr3.length; i++)
			System.out.print(arr3[i] + " ");
		System.out.println();
	}

}
