import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Student2 implements Comparable<Student2>
{
	private String name;
	private int age;

	public Student2(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString()
	{
		return name + ":" + age;
	}

	@Override
	// 순서지정없으면 오류남
	public int compareTo(Student2 p)
	{
//		return this.age - p.age; //나이 오른차순
		return p.name.compareTo(this.name); // 이름 역순으로 정렬
	}
}

public class Ex09_Comparable
{
	public static void main(String[] args)
	{
		Set<Student2> tree = new TreeSet<>();
		tree.add(new Student2("홍길동", 30));
		tree.add(new Student2("전우치", 40));
		tree.add(new Student2("손오공", 20));

		for (Student2 s : tree)
			System.out.println(s);
		System.out.println();
	}
}
