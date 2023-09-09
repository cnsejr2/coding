import java.util.Scanner;

public class p14503 {

	static int n, m, r, c, d;
	static int[][] board;
	static int count = 1;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, 1, 0, -1};
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
	
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		dfs(r, c, d);
		System.out.println(count);

		sc.close();
	}


	private static void dfs(int x, int y, int dir) {
		board[x][y] = 2; // 청소를 했다는 의미

		for (int i = 0; i < 4; i++) {
			dir -= 1; // 왼쪽 방향으로 돌면서 탐색
			if (dir == -1) {
				dir = 3;
			}
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				// 벽도 아니고 이미 청소한 곳도 아니라면 청소하러 이동한다.
				if (board[nx][ny] == 0) {
					count++;
					dfs(nx, ny, dir);
					// 일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 
					// 해당 위치부터 계산하지만
					// 이 문제는 후진할 때만 이전 길을 되돌아가며 확인할 수 있으므로
					// return 을 해서 다시 되돌아와도 더 이상 움직이면 안됨
					return;
				}
			}
		}

		// 반복문을 빠져 나왔다는 것은 주변에 더 이상 청소할 공간이 없다는 의미
		int d = (dir + 2 ) % 4;
		int bx = x + dx[d];
		int by = y + dy[d];
		if (bx >= 0 && by >= 0 && bx < n && by < m && board[bx][by] != 1) {
			dfs(bx, by, dir);
		}
	}
}
			

