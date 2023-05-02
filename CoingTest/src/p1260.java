import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1260 {
	static int n;
	static int m;
	static int start;
	static boolean visited[];
	static int[][] check;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
	
		check = new int[1001][1001]; // 좌표를 그대로 받아들이기 위해 +1 선언
		visited = new boolean[1001]; // 초기값 false
		
		// 간선 연결상태 저장
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			check[x][y] = 1;
			check[y][x] = 1;
		}
		
		dfs(start);
		System.out.println();
		
		visited = new boolean[1001];
		BFS(start);
		System.out.println();
		
		sc.close();
	}

	private static void BFS(int i) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visited[i] = true;
		System.out.print(i + " ");
		
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int j = 1; j <= n; j++) {
				if (check[temp][j] == 1 && visited[j] == false) {
					queue.add(j);
					visited[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		System.out.print(i + " ");
		visited[i] = true;
		for (int j = 1; j <= n; j++) {
			if (check[i][j] == 1 && visited[j] == false) {
				dfs(j);
			}
		}
		
	}

}
