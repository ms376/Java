import java.util.ArrayList;
import java.util.List;

public class Ex01_ArrayList
{

	public static void main(String[] args)
	{
		// ArrayList와 나머지 컬렉션들은 데이터를 저장하는 내부적인
		// 자료구조만 다를 뿐 사용법은 100%동일하다

		List<String> list = new ArrayList<>(); // 자식을 부모에 대입
//		객체저장 add()
//			add(객체) : 순차적으로 저장 인는 0부터 자동부여
//			add(인덱스,객체) : 데이터저장시 인덱스를 직접부여
//							단, 인덱스를 건너뛰면 에러발생. 
//							이미 객체가 생성되었을경우 삽입(끼워넣기가됨)
		list.add("orange"); // 추가할때 add() 사용
		list.add("apple");
		list.add("apple");
		list.add("banana");

		// 추가
		list.add(4, "banana");
//		list.add(10,"banana"); 	// 런타임에러 ( 인덱스를 뛰어 넘을 수 없음)
		list.add(2, "banana"); // 2번째 강제삽입
		list.add(list.size(), "mango"); // list 끝에 삽입하세요
		System.out.println("중복 저장 전 출력(객체수):" + list.size());

//		중복저장
//			: List는 배열의 특성을 가지므로 데이터의 중복저장이 허용된다.
//			동일한 데이터라 할지라도 index로 구분 할 수 있기 때문이다.

		System.out.println(list.add("mango") ? "중복저장됨" : "중복저장안됨");
		System.out.println("중복저장 후 객체수: " + list.size());

//		컬렉션 출력시 for문사용. 인덱스를이용해야함으로 get()사용

		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();

		list.remove(0); // 첫번째 데이터가 삭제되면 나머지순서가 앞으로 당겨짐.
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
	}

}
