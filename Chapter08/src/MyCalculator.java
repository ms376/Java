import java.util.Scanner;

public class MyCalculator
{
	// static 은 main 실행이전 실행.
	public static void showMenu()
	{
		System.out.println("======================================");
		System.out.println(" 메뉴를 선택하세요. (※숫자만 입력※)");
		System.out.println("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 5.제곱");
		System.out.println("0.종료");
		System.out.println("=======================================");
	}

	public static void addNum(int num1, int num2)
	{
		int result = num1 + num2;
		System.out.printf("%d + %d = %d", num1, num2, result);
	}

	public static void minuNum(int num1, int num2)
	{
		int result = num1 - num2;
		System.out.printf("%d - %d = %d", num1, num2, result);
	}

	public static void multNum(int num1, int num2)
	{
		int result = num1 * num2;
		System.out.printf("%d * %d = %d", num1, num2, result);
	}

	public static void dvNum(int num1, int num2)
	{
		if(num2==0) {
			System.out.println("0으로 나눌수 없습니다.");
			return; // if 문일경우 continue 대신 사용.
		}
		int result1 = num1 / num2;
		int result2 = num1 % num2;
		System.out.printf("%d / %d = %d", num1, num2, result1);
		System.out.printf("%d % %d = %d", num1, num2, result2);
	}

	public static void poNum(int num1, int num2)
	{
		int result = 1;
		for (int i = 0; i < num2; i += 1)
		{
			result *= num1;
		}
		System.out.printf("제곱 결과: %d ", result);
	}

//  유효성 검사 (예외처리)
	public static boolean checkNum(char ch)
	{
		if (ch >= '0' && ch <= '9')
		{
			return true;
		} else
		{
			return false;
		}
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			showMenu();

//			int num = sc.nextInt();
//			nextLine()으로 하면 런타임 에러남. 다음줄에 공백을 인식.
			char myChar = scanner.next().charAt(0);
			int num = myChar - '0';

			if (!checkNum(myChar))
			{
				System.out.println("메뉴를 잘못 선택했습니다.");
				continue;
			}

			if (num == 0)
			{
				break;
			} else
			{
				if (num > 5)
				{
					System.out.println("메뉴를 잘못 입력하셨습니다.");
					continue;
				}

				System.out.print("첫번째 숫자 : ");
				int num1 = scanner.nextInt();

				System.out.print("두번째 숫자 : ");
				int num2 = scanner.nextInt();

				if (num == 1)
				{
					addNum(num1, num2);
					System.out.println();
				} else if (num == 2)
				{
					minuNum(num1, num2);
					System.out.println();
				} else if (num == 3)
				{
					multNum(num1, num2);
					System.out.println();
				} else if (num == 4)
				{
					dvNum(num1, num2);
					System.out.println();
				} else if (num == 5)
				{
					poNum(num1, num2);
					System.out.println();
				}
			}
		}
		System.out.println("계산기를 종료합니다.");
		scanner.close();
	}
}
