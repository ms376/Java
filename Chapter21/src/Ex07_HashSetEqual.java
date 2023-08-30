import java.util.HashSet;

class Student
{
	private String name;
	private int age;

	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString()
	{
		return name + ":" + age;
	}

//	@Override
//	public int hashCode()
//	{
//		int num= age%3;
//		System.out.println(num);
//		return num;
//	}

// 해쉬코드 출력
	@Override
	public int hashCode()
	{
		int num = java.util.Objects.hash(name, age);
		System.out.println(num);
		return num;
	}

	public boolean equals(Object obj)
	{
		System.out.println("비교를 합니다.");
		if (age == ((Student) obj).age)
			return true;
		else
			return false;
	}
}

public class Ex07_HashSetEqual
{
	public static void main(String[] args)
	{
		HashSet<Student> set = new HashSet<>();
		set.add(new Student("홍길동", 20));
		set.add(new Student("전우치", 20));
		set.add(new Student("홍길동", 25));
		System.out.println("객체 수 :" + set.size());
		for (Student s : set)
			System.out.print(s.toString() + '\t');
		System.out.println();
		// 추가
		// 기본클래스의 객체 중복저장
		// : 기본 클래스인 경우 별도의 오버라이딩 없이도 중복이 제거된다.
		// 따라서 아래의 add()메서드는 false를 반환한다.
		System.out.println(set.add(new Student("홍길동", 25)) ? "저장성공" : "저장실패");
		// 저장실패임으로 3개출력
		System.out.println("중복 저장 후 객체수: " + set.size());
		System.out.println();

		System.out.println(set.add(new Student("홍길동", 30)) ? "저장성공" : "저장실패");
		System.out.println("중복 저장 후 객체수: " + set.size());
		// 성공임으로 4

		// 포함 여부 확인
		// : set 컬렉션 내에 해당 객체가 있는지만 확인한다
		System.out.println(set.contains(new Student("홍길동", 25)) ? "있네" : "없네");
		for (Student s : set)
			System.out.print(s.toString() + '\t');
		System.out.println();

		// 객체 삭제
		// : set 컬렉션은 인덱스가 없으므로 객체의 참조값을 통해서만 삭제가능
		System.out.println(set.remove(new Student("홍길동", 25)) ? "지웠다" : "못지웠다");
		System.out.println("홍길동 지우고 객체수 : " + set.size());
		for (Student s : set)
			System.out.print(s.toString() + '\t');
		System.out.println();

		// 전체 삭제
		// : list 컬렉션과 동일.
		System.out.println(set.removeAll(set));
		System.out.println("전체 삭제후 갯수는 : " + set.size());

	}

}
