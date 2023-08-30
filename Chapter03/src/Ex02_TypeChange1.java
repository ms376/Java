
public class Ex02_TypeChange1
{

	public static void main(String[] args)
	{
		int num1 = 1;
		byte num2 = 1;
		byte num3 = 127;
//		byte num4 = 128;

		short num5 = 1;
//		num2 = num5;
		num2 = (byte) num5;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num5);
	}

}
