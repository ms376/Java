interface Human1
{
	int MAN = 1;
	int WOMAN = 2;
}

interface Machine1
{
	int TAKNK = 1;
	int AIRPLANE = 2;
}

public class Ex01_Constants
{
	public static void main(String[] args)
	{
		creatUnit(Machine1.TAKNK);
		creatUnit(Human1.MAN);
	}

	public static void creatUnit(int kind)
	{
		switch (kind) 		// 상수로 받음
		{
		case Machine1.TAKNK:
			System.out.println("탱크를 만듭니다.");
			break;

		case Machine1.AIRPLANE:
			System.out.println("비행기를 만듭니다");
			break;
		}
	}
}
