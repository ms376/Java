import java.util.Iterator;
import java.util.LinkedList;

public class Ex05_PrimitiveData
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();

		list.add(10);
		list.add(20);
		list.add(30);

		for (Iterator<Integer> itr = list.iterator(); itr.hasNext();)
		{
			int n = itr.next();
			System.out.println(n);
		}
//		Iterator<Integer> itr = list.iterator();
//		while (itr.hasNext())
//		{
//			str = itr.next();
//			System.out.println(str+'\t');
//			if (str.equals("orange"))
//				System.out.println();
//		}
	}
}
