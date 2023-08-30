import java.util.Random;
import java.util.Scanner;

public class QuLottoArray
{
	static Random rnd = new Random();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		int[] arr = new int[6];
		randomcreate(arr);
		showArray(arr, " 난수생성 직후 로또번호 출력");
		bubbleSort(arr, 1);
		showArray(arr, " 버블정렬 이후 로또번호 출력");
	}

	public static void bubbleSort(int[] arrPa, int orderS)
	{
		int temp;
		for (int i = 0; i < arrPa.length - 1; i++)
		{
			for (int j = 0; j < (arrPa.length - 1) - i; j++)
			{
				if (arrPa[j] > arrPa[j + 1])
				{
					temp = arrPa[j];
					arrPa[j] = arrPa[j + 1];
					arrPa[j + 1] = temp;

				}
			}
		}
	}

	public static void showArray(int[] arr, String message)
	{
		System.out.println(message);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}

	public static void randomcreate(int[] arrParam)
	{
		rnd.setSeed(System.currentTimeMillis());
		while (true)
		{
			for (int i = 0; i < arrParam.length; i++)
			{
				arrParam[i] = rnd.nextInt(45) + 1; // 1~45까지 정수 생성
			}
			boolean ranFlag = false;
			for (int i = 0; i < arrParam.length; i++)
			{
				for (int j = 0; j < arrParam.length; j++)
				{
					if (i != j && arrParam[i] == arrParam[j])
					{
						ranFlag = true;
					}
				}
			}
			if (ranFlag == false)
				break;
		}

	}

}
