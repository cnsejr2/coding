import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2667 {

	static ArrayList<Integer> result; // 단지 집의 수 저장
	static int n;
	static int count = 0;
	static int[][] map;
	static boolean[][] visited; // 방문 체크
	static int[] dx = { 1, -1, 0, 0}; // x축 기준 - 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1}; // y축 기준 - 상 하 좌 우
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		
		result = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					count = 1;
					dfs(i, j);
					result.add(count);	
				}
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
		sc.close();
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
					count++;
				}		
			}
		}
		
	}

}
