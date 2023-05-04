import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p4963 {
	static int w;
	static int h;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			matrix = new int[h][w];
			visited = new boolean[h][w];
			int count = 0;
			
			if (w == 0 && h == 0) { break; }
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (matrix[i][j] == 1 && visited[i][j] == false) {
						count++;
						dfs(i, j);
					}
				}
			}
			bw.write(count + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
				if (matrix[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
	}

}
