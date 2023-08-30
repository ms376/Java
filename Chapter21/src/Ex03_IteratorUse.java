import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex03_IteratorUse
{
	public static void main(String[] args)
	{
		List<String> list = new LinkedList<>(); // 자식을 부모에 대입

		list.add("orange"); // 추가할때 add() 사용
		list.add("apple");
		list.add("apple");
		list.add("banana");

		// 결과확인
		for (String s : list)
			System.out.print(s + '\t');
		System.out.println();

		// 반복자.
		Iterator<String> itr = list.iterator();

		String str;
		while (itr.hasNext())
		{
			str = itr.next();
			System.out.print(str + '\t');

			if (str.equals("orange"))
				itr.remove();
		}
		System.out.println();

		itr = list.iterator();

		while (itr.hasNext())
			System.out.print(itr.next() + '\t');

		System.out.println();

		// 추가
		// 수정하기: Insert와동일) set(인덱스, 객체)
		list.set(2, "holy_moly");

		// 결과확인
		for (String s : list)
			System.out.print(s + '\t');
		System.out.println();

		// 포함여부확인 : contains (객체) : 찾고자하는 객체가 있으면 true or false
		System.out.println(list.contains("holy_moly") ? "트루다" : "펄스다");
		System.out.println(list.contains("ho") ? "트루다" : "펄스다");

		// 삭제(del) : 1. 인덱스로 삭제
		// remove(인덱스) : 삭제가 완료되면 해당객체반환, 후 자동재부여, 확인가능
		// indexof를 통해 해당 객체의 인덱스를 찾은 후 삭제.

		int index = list.indexOf("holy_moly");
		System.out.println("holymoly 지우기 : " + index);
		list.remove(index);

		for (String s : list)
			System.out.print(s + '\t');
		System.out.println();
		System.out.println();
		System.out.println(list.remove("hholy") ? "삭제 성공" : "삭제실패");
		// 객체가 없음 ,실패
		for (String s : list)
			System.out.print(s + '\t');
		System.out.println();
		System.out.println(list.remove("apple") ? "삭제 성공" : "삭제실패");
		// 객체가 잇음 ,성공 apple이 하나만 지워졌음
		for (String s : list)
			System.out.print(s + '\t');
		System.out.println();
		
		System.out.println();
		//전체 삭제 : 
		list.removeAll(list);
		list.clear();		//깨끗하게 정리.
		System.out.println("전체 삭제 후 객체수 : "+list.size());
	}
}
