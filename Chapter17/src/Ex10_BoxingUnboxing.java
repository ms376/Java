
public class Ex10_BoxingUnboxing
{

	public static void main(String[] args)
	{
		Integer iObj = Integer.valueOf(10);
		Double dObj = Double.valueOf(3.14);

		int num1 = iObj.intValue();
		double num2 = dObj.doubleValue();

		System.out.println(num1 + " : " + iObj);
		System.out.println(num2 + " : " + dObj);
		System.out.println();

		iObj = Integer.valueOf(iObj.intValue() + 10);
		dObj = Double.valueOf(dObj.doubleValue() + 1.2);

		System.out.println(iObj);
		System.out.println(dObj);
	}

}
