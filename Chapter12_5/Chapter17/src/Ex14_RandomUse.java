import java.util.Random;

public class Ex14_RandomUse
{

	public static void main(String[] args)
	{
		Random rand1 = new Random();
		for (int i = 0; i < 10; i++)
			System.out.print(rand1.nextInt(20) + " ");
		System.out.println();
		Random rand2 = new Random(12);
		for (int i = 0; i < 10; i++)
			System.out.print(rand2.nextInt(10) + " ");
		System.out.println();

		/*
		 * 시드를 부여하려면 setSeed()메서드를 사용 시간을 계속 흘러가므로 항상 새로운 Seed를 생성 할 수 있다.
		 */
		System.out.println("\n 난수생성2 : 변화하는 시간으로 씨드지정.");
		Random rand3 = new Random();
		rand3.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 10; i++)
			System.out.print(rand3.nextInt(100) + " ");

		/* nethInt()에 인수가 없는경우에는 음수, 양수가 혼용된 난수가 생성됨. */
		System.out.println("\n 난수생성3 : nextInt() 인수없음.");
		Random rand4 = new Random();
		rand3.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 5; i++)
			System.out.print(rand4.nextInt() + " ");

	}
}
