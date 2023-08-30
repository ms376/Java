import java.util.Arrays;

class Person implements Comparable
{
	private String name;
	private int age;

	public Person(String name, int age)
	{
		this.age = age;
		this.name = name;
	}

	public int compareTo(Object o)  //오름차순 정렬
	{
		Person p = (Person) o;

//		int nNum= this.name.compareTo(p.name); //나이순 정렬
//		return nNum;

		if (this.age > p.age)
			return 1;
		else if (this.age < p.age)
			return -1;
		else
			return 0;
	}

	public String toString()
	{
		return name + ": " + age;
	}
}

public class Ex17_ArrayObjSort
{

	public static void main(String[] args)
	{
		Person[] arr = new Person[3];
		arr[0] = new Person("홍길동", 29);
		arr[1] = new Person("전우치", 15);
		arr[2] = new Person("손오공", 37);

		Arrays.sort(arr);

		for (Person p : arr)
			System.out.println(p);
	}

}
