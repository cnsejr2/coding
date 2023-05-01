import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1206 {

	static boolean visited[];
	static ArrayList<Integer> A[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
	
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		
		for (int i = 1; i < N; i++) {
			Collections.sort(A[i]);
		}
		
		visited = new boolean[N + 1];
		DFS(start);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(start);
		System.out.println();
		
		sc.close();
	}

	private static void BFS(int Node) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;
		
		while (!queue.isEmpty()) {
			int now_Node = queue.poll();
			System.out.print(now_Node + " ");
			for (int i : A[now_Node]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);	
				}
			}
		}
	}

	private static void DFS(int Node) {
		// TODO Auto-generated method stub
		System.out.print(Node + " ");
		visited[Node] = true;
		for (int i : A[Node]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
		
	}

}
