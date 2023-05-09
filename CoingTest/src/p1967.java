import java.util.Scanner;

public class p1967 {
	static int n;
	static int[][] map;
	static int[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n + 1][n + 1];
		visited = new int[n + 1][n + 1];
		
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			map[a][b] = map[b][a] = c;
		}
		

		for (int i = 1; i <= n; i++) {
			for (int j = 1;j <= n; j++) {
				if (map[i][j] != 0  && visited[i][j] == 0) {
					dfs(i, j);
				}
			}
		}
		

		sc.close();
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = map[x][y];
		for (int i = 1; i <= n; i++) {
			if (map[x][i] != 0 && visited[x][i] == 0) {
				dfs(x, i);
			}
		}
	}
	
	

}
