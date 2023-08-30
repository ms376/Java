
public class Ex02_ReturnForExit
{

	public static void main(String[] args)
	{
		devide(4, 2);
		devide(6, 2);
		devide(8, 0);
	}

	public static void devide(int num1, int num2)
	{
		if (num2 == 0)
		{
			System.out.println("0으로 나눌 수 없습니다.");
			return;
		}
		System.out.println("나눗샘 결과:" + (num1 / num2));
	}
}
