import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		// 학생 수만큼 인접리스트 초기화하기
		for (int i = 0; i <= N;i++) {
			A.add(new ArrayList<>());
		}
		int indegree[] = new int[N + 1];
		// 진입 차수 배열 초기화하기
		for (int i = 0 ; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A.get(S).add(E);
			indegree[E]++; // 진입 차수 배열 데이터 저장 부분
		}
		
		// 위상정렬 실행
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <=  N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int next : A.get(now)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		sc.close();
	}

}
