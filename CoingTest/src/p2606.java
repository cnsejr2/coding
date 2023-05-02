import java.util.Scanner;

public class p2606 {

	static int[][] check;
	static boolean[] visited;
	static int n;
	static int m;
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		check = new int[1001][1001];
		visited = new boolean[1001];
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			check[x][y] = check[y][x] = 1;
		}
		
		dfs(1);
		System.out.println(cnt);
		
		sc.close();
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		
		for (int j = 1; j <= n; j++) {
			if (check[i][j] == 1 && visited[j] == false) {
				cnt++;
				dfs(j);
			}
		}
		
	}

}
