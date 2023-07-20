import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14620 {

	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0 , 1, 0, -1 };
	
	private static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];
		
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(result);

	}

	private static void dfs(int count, int sum) {
		// TODO Auto-generated method stub
		if (count == 3) {
			result = Math.min(result, sum);
		} else {
			for (int i = 2; i < n; i++) {
				for (int j = 2; j < n; j++) {
					if (!visited[i][j] && check(i, j)) {
						visited[i][j] = true;
						int s = sum(i, j);
						
						dfs(count + 1, sum + s);
						
						visitClear(i, j);
						visited[i][j] = false;
					}
				}
			}
		}
	}

	private static void visitClear(int x, int y) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			visited[nx][ny] = false;
		}
		
	}

	private static int sum(int x, int y) {
		// TODO Auto-generated method stub
		int s = map[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			visited[nx][ny] = true;
			s += map[nx][ny];
		}
		
		return s;
	}

	private static boolean check(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (visited[nx][ny]) {
				return false;
			}
		}
		return true;
	}

}
