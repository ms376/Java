
class Book3
{
	String author;
}

public class Ex03_toString2
{

	public static void main(String[] args)
	{
		Book3 myBook = new Book3(); //객체생성
		myBook.author = "홍길동";
		System.out.println(myBook.author);
		System.out.println(myBook);
	}

}
