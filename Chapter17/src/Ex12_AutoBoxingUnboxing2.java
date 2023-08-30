
public class Ex12_AutoBoxingUnboxing2
{

	public static void main(String[] args)
	{
		Integer num = 10;		// 오토박싱
		num++;					// Integer.valueOf(num.intValue()+1);
		System.out.println(num);// 오토박싱과 오토언박싱 동시진행

		num += 3;				// Integer.valueOf(num.intValue()+3);
		System.out.println(num);

		int r = num + 5;
		Integer rObj = num - 5;
		System.out.println(r);
		System.out.println(rObj);

	}

}
