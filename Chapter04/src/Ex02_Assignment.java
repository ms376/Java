
public class Ex02_Assignment
{

	public static void main(String[] args)
	{
		short num = 10;
		num += 77L;
		System.out.println(num);

		num = (short) (num + 77L);
		System.out.println(num);
		int n=5;
//		n=(int)(n*2.7); //14번줄식과 15번줄식 동일함
		n*=2.7;
		System.out.println(n);
	}

}
