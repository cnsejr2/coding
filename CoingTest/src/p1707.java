import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p1707 {
	static ArrayList<Integer>[] A;
	static int[] check;
	static boolean[] visited;
	static boolean IsEven;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * 노드끼리 서로 인접하지 않은 두 집합으로
		 * 그래프의 노드를 나눌 수 있을 떄 그래프를 이분 그래프라고 한다.
		 * 그래프가 입력으로 주어졌을 때 
		 * 이 그래프가 이분 그래프인지 여부를 판별하는 프로그램
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		// 주어진 테스트 케이스 만큼 돌림
		for (int t = 0 ; t < testCase; t++) {
			String[] s = br.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			
			// 0번째 안쓸 에정
			A = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			check = new int[V + 1];
			IsEven = true;
			for (int i = 1; i <= V; i++) {
				A[i] = new ArrayList<Integer>();
			}
			// 에지 데이터 저장하기
			for (int i = 0; i < E; i++) {
				s = br.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				A[start].add(end);
				A[end].add(start);
			}
			// 모든 노드에서 DFS 실행 예정
			for (int i = 1; i <= V; i++) {
				if (IsEven) {
					DFS(i);
				} else {
					break;
				}
			}
			if (IsEven) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static void DFS(int start) {
		// TODO Auto-generated method stub
		visited[start] = true;
		for (int i : A[start]) { // 인접리스트로 받아서 start에서 연결된 모든 노드 탐색
			if (!visited[i]) {
				// 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요
				check[i] = (check[start] + 1) % 2;
				DFS(i);
			} else if (check[start] == check[i]) {
					IsEven = false;
			}
		}
	}

}
