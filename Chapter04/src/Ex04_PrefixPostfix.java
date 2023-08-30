
public class Ex04_PrefixPostfix
{

	public static void main(String[] args)
	{
		int num = 10;
		System.out.println(++num);
		System.out.println(num);
		System.out.println(num++);
		System.out.println(num);
		
		int num1=7;
		int num2, num3;
		
		num2=++num1;
		num3=--num1;
		System.out.println("전증/감");
		System.out.printf("num1=%d,num2=%d,num3=%d",num1,num2,num3);
	}

}
