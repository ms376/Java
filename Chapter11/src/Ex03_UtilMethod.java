
public class Ex03_UtilMethod
{

	public static void main(String[] args)
	{
		MyCalculator calc = new MyCalculator();
		int num1 = calc.adder(1, 2);
		System.out.println(num1);

		int num2 = MyCalculator.adder(2, 3);
		System.out.println(num2);

	}

}
