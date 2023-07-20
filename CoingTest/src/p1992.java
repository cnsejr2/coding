import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1992 {

	static int n;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		QuadTree(0, 0, n);
		
		System.out.println(sb);
		
	}

	private static void QuadTree(int x, int y, int size) {
		// TODO Auto-generated method stub
		
		// 압축이 가능할 경우 하나의 색상으로 압축해준다.
		if (isPossible(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}
		
		int newSize = size / 2;
		
		sb.append('(');
		
		QuadTree(x, y, newSize); // 왼쪽 위
		QuadTree(x, y + newSize, newSize); // 오른쪽 위
		QuadTree(x + newSize, y, newSize); // 왼쪽 아래
		QuadTree(x + newSize, y + newSize, newSize); // 오른쪽 아래

		sb.append(')'); 
		
	}

	// 압축이 가능한지 해당 공간을 체크
	private static boolean isPossible(int x, int y, int size) {
		// TODO Auto-generated method stub
		int value = map[x][y];
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (value != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
