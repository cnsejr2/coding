import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2573 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] sub;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		sub = new int[n + 1][m + 1];
		visited  = new boolean[n + 1][m + 1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		do {
			count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0 && visited[i][j] == false) {
						count++;
						dfs(i, j);
					}
				}
			}
			if (count == 0) {
				cnt = 0; break;
			}
			if (count == 1) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (visited[i][j]) {
							for (int k = 0; k < 4; k++) {
								int mx = i + dx[k];
								int my = j + dy[k];
								
								if (mx >= 0 && my >= 0 && mx < n && my < m) {
									if (map[mx][my] == 0) { 
										sub[i][j]++;
									}
								}
							}
						}
					}
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						map[i][j] = map[i][j] - sub[i][j];
						if (map[i][j] < 1) { map[i][j] = 0; }
					}
				}
				visited  = new boolean[n + 1][m + 1];
				sub = new int[n + 1][m + 1];
				cnt++;
			}
		} while (count == 1);
		System.out.println(cnt);
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx >= 0 && my >= 0 && mx < n & my < m) {
				if (map[mx][my] != 0 && visited[mx][my] == false) {
					dfs(mx, my);
				}
			}
		}
	}

}
