import java.util.Random;
import java.util.Scanner;

// 버블정렬
//Bubble Sort는 인접한 두 수를 비교하여 큰 수를 뒤로 보내는 
//간단한 정렬 알고리즘이다.
//첫번째 자료와 두번째 자료를, 두번째 자료와 세번째 자료를...
//순차적으로 비교하여 교환한다. 
//1회전을 수행하면 가장 큰수가 맨 뒤로 이동하므로 맨끝의 수는 
//제외하고 다시 처음부터 비교한다.
//다른 정렬 알고리즘에 비해 속도가 상당히 느린 편이지만, 코드가 
//단순하므로 자주 사용된다.
//원소의 이동이 거품이 수면으로 올라오는 듯한 모습을 보이기 때문에
//Bubble Sort라는 이름을 가지게 되었다

public class BubbleSort
{
	// 전역 변수 형태로 생성하여 모든 메소드에서 접근가능
	static Random rnd = new Random();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		// 중복없는 난수 [10] 생성
		int[] arr = new int[10];
		// 난수 생성후 arr배열에 차징하기 위한 메소드 호출
		randomcreate(arr);

		// 2. 생성된 난수를 통해 초기화된 배열을 출력(정렬전 출력)
		showArray(arr, " 난수 생성 직후 배열출력");

		// 3. 정렬의 방법을 선택한다.(1. 오름차순 2. 내림차순)
		int orderSelect = menuSelect();

		// 4. 버블정렬 알고리즘을 통한 정렬을 진행한다.
		bubbleSort(arr, orderSelect);

		// 5. 정렬 후 출력
		showArray(arr, "버블정렬 이후 배열출력");
	}

	public static void bubbleSort(int[] arrPa, int orderS)
	{
		// swap(자리변경)을 위한 임시변수 생성
		int temp;
		/*
		 * 크기가 10인 배열이므로 스캔은 9번만 반복하면 된다. 즉 i의 증가치는 0~8 까지 변하게 된다.
		 */
		for (int i = 0; i < arrPa.length - 1; i++)
		{
			/*
			 * 실제 요소값에 대한 비교를 진행합니다. 버블정렬의 목적은 오름차순일때 큰 숫자를 제일 뒤로 보내주는 것이다. 즉 요소1과 요소2를 비교하여
			 * 요소1이 크다면 서로 자리를 바꾸어 큰 숫자를 뒤로 보내준다.
			 */
			for (int j = 0; j < (arrPa.length - 1) - i; j++)
			{
				/*
				 * j가 0일때 : arrPa[0] > arrPa[1] 비교 j가 1일때 : arrPa[1] > arrPa[2] 비교 ... ...
				 */
				if (orderS == 1) // 오름차순을 선택할 때.
				{
					if (arrPa[j] > arrPa[j + 1])
					{
						/*
						 * 앞의 요소가 크다고 판단이 되면 서로 swap하여 자리를 서로 바꿔서 큰 숫자를 뒤로보냄
						 */
						temp = arrPa[j];
						arrPa[j] = arrPa[j + 1];
						arrPa[j + 1] = temp;

						// 값의 변경이 있을 때 마다 배열 전체를 출력하기.
//						showArray(arrPa, "SWAP중(오름차순 정렬중): " + (swapCount++) + " 회 교환됨");
					}
				} else if (orderS == 2)
				{

					if (arrPa[j] < arrPa[j + 1])
					{
						temp = arrPa[j];
						arrPa[j] = arrPa[j + 1];
						arrPa[j + 1] = temp;

					}
				}
			}
		}
	}

	public static int menuSelect()
	{
		System.out.println("정렬할 방법을 선택하세요.");
		System.out.println("1. 오름차순 // 2. 내림차순");
		return scanner.nextInt();
	}

	public static void showArray(int[] arr, String message)
	{
		System.out.println(message);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	} // end of showArry();

	public static void randomcreate(int[] arrParam)
	{
		rnd.setSeed(System.currentTimeMillis());
		/*
		 * 난수 생성 방법 : 1. 난수 10개를 우성 생성한 후 배열에 담아둔다 2. 배열 전체를 대상으로 중복 확인을 한다. 3. 만약 중복되는
		 * 요소가 발견되면 다시 1번으로 돌아가 재생성한다 4. 중복되는 요소가 없다면 함수를 종료하고 메인으로 돌아간다.
		 */
		while (true)
		{
			// 1. 난수 10개를 생성 후 배열에 담기
			for (int i = 0; i < arrParam.length; i++)
			{
				arrParam[i] = rnd.nextInt(99) + 1; // 1~99까지 정수 생성
			}
			// 2. 중복 확인
			boolean ranFlag = false;
			// 중복 체크를 위한 변수(false라면 중복된 난수가 없는 경우,)
			// 중복된 난수가 발견된다면 true로 값을 변경.
			for (int i = 0; i < arrParam.length; i++)
			{
				for (int j = 0; j < arrParam.length; j++)
				{
					// 비교 조건은 인덱스i와 j가 서로다를때임.
					// 인덱스가 동일할 시 같은숫자임.
					if (i != j && arrParam[i] == arrParam[j])
					{
						// 중복 발견 시 true로 값을 변경
						ranFlag = true;
					}
				}
			}
			// 3. 중복이 없다면 break로 while 루프탈출
			if (ranFlag == false)
				break;
		}

	}

}
