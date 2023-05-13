import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p1743 {
	static int n, m, k, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0};
	static int[] dy = { 0, 0, -1, 1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[n + 1][m + 1];
		visited = new  boolean[n + 1][m + 1];
		
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					count = 1;
					dfs(i, j);
					max = Math.max(count,  max);
				}
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx > 0 && my > 0 && mx <= n && my <= m) {
				if (map[mx][my] == 1 && visited[mx][my] == false) {
					count++;
					dfs(mx, my);
				}
			}
		}
	}

}
