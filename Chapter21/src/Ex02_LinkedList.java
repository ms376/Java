import java.util.LinkedList;
import java.util.List;

public class Ex02_LinkedList
{

	public static void main(String[] args)
	{
		List<String> list = new LinkedList<>(); // 자식을 부모에 대입

		// 객체저장 : 순서있음 , 중복허용
		list.add("orange"); // 추가할때 add() 사용
		list.add("apple");
		list.add("apple");
		list.add("banana");

		// 중간에 삽입가능 ,편함. ( 데이터 추가, 삭제가 많을때 사용함)
		list.add(2, "mango");

		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();

		list.remove(2); // 첫번째 데이터가 삭제되면 나머지순서가 앞으로 당겨짐.
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
	}
}
//orange	apple	mango	apple	banana	
//orange	apple	apple	banana	
