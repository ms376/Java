
public class Ex04_DoubleError1
{

	public static void main(String[] args)
	{
		double num1 = 1.0000001;
		System.out.println(num1);
		double num2 = 2.0000001;
		System.out.println(num1);
		double result = num1 + num2;

		System.out.println(result);

		float f3 = 100;
//		float f4 = 3.14; // error
		float f4 = (float) 3.14;
		float f5 = 3.14F;

		System.out.println("f3=" + f3);
		System.out.println("f4=" + f4);
		System.out.println("f5=" + f5);
	}

}
