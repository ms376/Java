import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex06_Set
{
	public static void main(String[] agrs)
	{
		Set<String> set = new HashSet<>();
		set.add("orange");
		set.add("apple");
		set.add("banana");
		set.add("apple");

		System.out.println("객체 수 :" + set.size());

		for (Iterator<String> itr = set.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();

		for (String s : set)
			System.out.print(s + '\t');
		System.out.println();
	}
}
