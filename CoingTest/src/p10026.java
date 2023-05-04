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
		
		visited = new boolean[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 'R' && visited[i][j] == false) {
					count++;
					dfs('R', i, j);
				} else if (matrix[i][j] == 'G' && visited[i][j] == false) {
					count++;
					dfs('G', i, j);
				} else if (matrix[i][j] == 'B' && visited[i][j] == false) {
					count++;
					dfs('B', i, j);
				}
			}	
		}
		
		System.out.print(count + " ");
		
		visited = new boolean[n][n];
		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((matrix[i][j] == 'R' || matrix[i][j] == 'G') && visited[i][j] == false) {
					count++;
					dfs2('R', 'G', i, j);
				} else if (matrix[i][j] == 'B' && visited[i][j] == false) {
					count++;
					dfs2('B', ' ', i, j);
				}
			}	
		}
		System.out.print(count);
		sc.close();
	}
	private static void dfs(char color, int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx >= 0 && my >= 0 && mx < n && my < n) {
				if (matrix[mx][my] == color && visited[mx][my] == false) {
					dfs(color, mx, my);
				}	
			}
		}
	}
	
	private static void dfs2(char color1, char color2, int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx >= 0 && my >= 0 && mx < n && my < n) {
				if ((matrix[mx][my] == color1 || matrix[mx][my] == color2) && visited[mx][my] == false) {
					dfs2(color1, color2, mx, my);
				}	
			}
		}
	}

}
