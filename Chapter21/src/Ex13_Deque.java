import java.util.ArrayDeque;
import java.util.Deque;

public class Ex13_Deque
{
	public static void main(String[] args)
	{
		Deque<String> deq = new ArrayDeque<>();
//		Deque<String> deq = new LinkedDeque<>();
		deq.offerFirst("A");
		deq.offerFirst("B");
		deq.offerFirst("C");
		
		for (String s : deq)	//리스트 확인
			System.out.print(s.toString()+'\t');
		System.out.println();
		System.out.println("---------------------------");

		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());

		System.out.println("---------------------------");
			
		deq.offerLast("A");
		deq.offerLast("B");
		deq.offerLast("C");
		
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());

		System.out.println("---------------------------");

		deq.offerLast("A");
		deq.offerLast("B");
		deq.offerLast("C");

		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
	}
}
