import java.util.Scanner;

public class p11724 {
	static int n;
	static int m;
	static int[][] matrix;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		matrix = new int[1001][1001];
		visited = new boolean[1001];
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			matrix[x][y] = matrix[y][x] = 1;
		}
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
		sc.close();
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		
		for (int j = 1; j <= n; j++) {
			if (matrix[i][j] == 1 && visited[j] == false) {
				dfs(j);
			}
		}
	}

}
