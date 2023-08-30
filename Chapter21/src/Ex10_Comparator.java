import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class MyStringComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		return s1.length() - s2.length();
	}
}

public class Ex10_Comparator
{
	public static void main(String[] args)
	{
		Set<String> tree = new TreeSet<>(new MyStringComparator());
		tree.add("홍길동");
		tree.add("전우치");
		tree.add("전우치");
		tree.add("멀린");
		tree.add("해리포터");

		for (String s : tree)
			System.out.println(s.toString() + '\t');

		System.out.println();
	}
}
