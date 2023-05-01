import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
			// 절댓값이 작은 데이터 우선
			int firstAbs = Math.abs(o1);
			int secondAbs = Math.abs(02);
			
			// 절댓값이 같은 경우 음수 우선
			if (firstAbs == secondAbs) {
				return o1 > o2 ? 1 : -1;
			}
			return firstAbs - secondAbs;
		});
		
		for (int i = 0;  i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) {
				if (myQueue.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(myQueue.poll());
				}
			} else {
				myQueue.add(request);
			}
		}
	
	}

}
