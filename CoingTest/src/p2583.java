import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p2583 {

	static int n;
	static int m;
	static int k;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> result;
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[m + 1][n + 1];
		visited = new boolean[m + 1][n + 1]; 
		result = new ArrayList<Integer>();
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int minX = Integer.parseInt(st.nextToken());
			int minY = Integer.parseInt(st.nextToken());
			int maxX = Integer.parseInt(st.nextToken());
			int maxY = Integer.parseInt(st.nextToken());
			for (int x = maxX; x > minX; x--) {
				for (int y = maxY; y > minY; y--) {
					if (map[y - 1][x - 1] != 1) {
						map[y - 1][x - 1] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && visited[i][j] == false) {
					count = 1;
					dfs(i, j);
					result.add(count);
				}
			}
		}
		Collections.sort(result);
		
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx >= 0 && my >= 00 & mx < m && my < n) {
				if (map[mx][my] == 0 && visited[mx][my] == false) {
					count++;
					dfs(mx, my);
				}
			}
		}
	}
	
}
