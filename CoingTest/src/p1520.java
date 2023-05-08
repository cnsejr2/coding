import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1520 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] dp;
	static int count;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[m + 1][n + 1];
		dp  = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(1, 1));
	}

	private static int dfs(int x, int y) {
		// TODO Auto-generated method stub
		if (x == m && y == n) {
			return 1;
		}
		if (dp[x][y] != -1) {
			return dp[x][y];
		} else {
			dp[x][y] = 0;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				
				if (mx < 1 || my < 1 || mx > m || my > n) {
					continue;
				}

				if (map[x][y] > map[mx][my]) {
					dp[x][y] += dfs(mx, my);
				}
				
			}
		}
		return dp[x][y];
		
	}

}
