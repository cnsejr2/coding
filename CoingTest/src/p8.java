import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			myQueue.add(i);
		}
		
		while (myQueue.size() > 1) {
			myQueue.poll();
			int temp = myQueue.poll();
			myQueue.add(temp);
		}
		
		System.out.println(myQueue.poll());
		sc.close();
	}

}
