class Book
{
	String title;
	int price, num = 0;

	Book()
	{
		title = "자바 프로그래밍";
		price = 30000;
	}

	Book(String t, int p)
	{
		title = t;
		price = p;
	}

	void print()
	{
		System.out.println("제   목 :" + title);
		System.out.println("가   격 :" + price);
		System.out.println("제목수량 :" + num);
		System.out.println("합계수량 :" + price * num);
		System.out.println("==========================");
	}
}

public class ConstructorUse
{
	public static void main(String[] args)
	{
		Book book1 = new Book();
		book1.print();
		Book book2 = new Book("자바 디자인패턴", 35000);
		book2.num = 10;
		book2.print();

	}

}
