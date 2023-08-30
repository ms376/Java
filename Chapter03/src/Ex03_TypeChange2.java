
public class Ex03_TypeChange2
{

	public static void main(String[] args)
	{
		int num1 = 2147483647;
		int num2 = 2147483647;
		long num3 = 2147483647;
		long num4 = 2147483647;

//		float num5=1.0;
		float num6 = 1.0f;

		double num7 = 30;
//		long num8 = 3000000071;
		int num9=(int)num4;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num6);
		System.out.println(num7);
		System.out.println(num9);
		
		char ch3 = 'A', ch4;
		int num10=2;
		ch4=(char)(ch3+num10);
		System.out.println("ch4="+ch4);
	}

}
