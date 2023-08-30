enum Human2
{
	MAN, WOMAN
}

enum Machine2
{
	TANK, AIRPLANE
}

public class Ex02_Enum
{

	public static void main(String[] args)
	{
		creatUnit(Machine2.TANK);
//		creatUnit(Human2.MAN);
//		if(Human2.MAN==0) {}
	}

	public static void creatUnit(Machine2 kind)
	{
		switch (kind)
		{
		case TANK:
			System.out.println("탱크를만듭니다.");
			break;
		case AIRPLANE:
			System.out.println("비행기를만듭니다");
			break;
		}
	}
}
