import java.util.Scanner;

public class p10026 {
	static int n;
	static char[][] matrix;
	static boolean[][] visited;
	static int count;
	static int k;
	static int[] dx = { 1, -1, 0, 0};
	static int[] dy = { 0, 0, -1, 1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		matrix = new char[n][n];
		
		// 배열 저장
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				char c = line.charAt(j);
				matrix[i][j] = c;
			}
		}
		for (k = 0; k < 2; k++) {
			visited = new boolean[n][n];
			count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == 'R' && visited[i][j] == false) {
						if (k == 1 && matrix[i][j] == 'G' || k == 0) { 
							count++;
							dfs(i, j);
						}
					}
				}
			}	
			System.out.print(count + " ");
		}

		
		sc.close();
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx > 0 && my > 0 && mx < n && my < n) {
				if (matrix[mx][my] == 'R' && visited[mx][my] == false) {
					if (k == 1 && matrix[mx][my] == 'G'|| k == 0) { 
						dfs(mx, my);
					}
				}	
			}
		}
	}

}
