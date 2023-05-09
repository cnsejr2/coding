import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1926 {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1}; 
	static int count;
	static ArrayList<Integer> result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map =new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		result = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				count = 0;
				if (map[i][j] == 1 && visited[i][j] == false) {
					count++;
					dfs(i, j);
					result.add(count);
				}
			}
		}
		
		System.out.println(result.size());
		if (result.size() == 0) {
			System.out.println("0");
		} else {
			System.out.println(Collections.max(result));
		}
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx >= 0 && my >= 0 && mx < n && my < m) {
				if (map[mx][my] == 1 && visited[mx][my] == false) {
					count++;
					dfs(mx, my);
				}
			}
		}
	}

}
