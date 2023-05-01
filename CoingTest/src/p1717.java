import java.util.Scanner;

public class p1717 {

	static int parent[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 집합 표현하기 - union Find
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) { // 대표 노드 초기화
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) { // 질의 계산하는 부분
			int question = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (question == 0) { // union
				union(a, b);
				
			} else { // 두 원소 같은지 보기
				boolean result = checkSame(a, b);
				if (result) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		
		sc.close();
	}

	private static void union(int a, int b) {
		// TODO Auto-generated method stub
		// 대표노드를 찾아서 연결하기
		a = find(a);
		b = find(b);
		if (a != b) {
			// 두 개 연결
			parent[b] = a;
		}
		
	}

	private static int find(int a) {
		// TODO Auto-generated method stub
		if (a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]); // value를 index로 바꿔서 다시 탐색
		}
	}
	
	private static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) { return true; }
		return false;
		
	}

}
