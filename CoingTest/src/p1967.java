import java.util.Scanner;

public class p1967 {
	static int n;
	static int[][] map;
	static int[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n + 1][n + 1];
		visited = new int[n+ 1];
		
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			map[a][b] = map[b][a] = c;
		}
		
		dfs(1, 1);
		
		for (int i = 1; i <= visited.length; i++) {
			System.out.print(visited[i] + " ");
		}
		sc.close();
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x] = map[x][y];
		
		for (int i = 1; i <= n; i++) {
			if (map[x][i] != 0 && visited[i] != 0) {
				dfs(x, i);
			}
		}
	}
	
	

}
