import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1189 {
	
	static int r, c, k;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
		
		visited[r - 1][0] = true;
		dfs(r - 1, 0, 1);
		
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int count) {
		// TODO Auto-generated method stub
		
		if (x == 0 && y == c - 1) {
			if (k == count) {
				cnt++;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++)  {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
				continue;
			}
			if (visited[nx][ny] == true || map[nx][ny] == 1) {
				continue;
			}
			visited[nx][ny] = true;
			dfs(nx, ny, count + 1);
			visited[nx][ny] = false;
		}
		
	
	}

}
