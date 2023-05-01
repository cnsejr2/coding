import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2178 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	// 아래, 오른쪽, 위, 왼쪽 탐색 하기
	static boolean[][] visited;
	static int[][] arr;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		
		BFS(0, 0);
		System.out.println(arr[n - 1][m -1]);
		
	}

	private static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]>queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) { // 상하좌우 탐색
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x >= 0 && y >= 0 && x < n && y < m ) { // 배열을 넘어가면 안되고
					if (arr[x][y] != 0 && !visited[x][y]) { // 0이여서 갈 수 없거나 기 방문이면 안됨
						// 이제 갈 수 있는 곳이다
						visited[x][y] = true;
						arr[x][y] = arr[now[0]][now[1]] + 1;
						queue.add(new int[] {x, y});
						
					}
				}
			}
		}
		
	}

}
