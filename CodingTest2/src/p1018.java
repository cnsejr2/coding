import java.util.Scanner;

public class p1018 {

	static boolean[][] arr;
	static int min = 64;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		
		int nRow = n - 7;
		int mCol = m - 7;
		
		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < mCol; j++) {
				find(i, j);
			}
		}
		
		System.out.println(min);
		
		sc.close();
	}

	private static void find(int x, int y) {
		int endX = x + 8;
		int endY = y + 8;
		int count = 0;
		
		boolean TF = arr[x][y];
		
		for (int i = x; i < endX; i++) {
			for (int j = y; j < endY; j++) {
				if (arr[i][j] != TF) {
					count++;
				}
				TF = (!TF);
			}
			TF = !TF;
		}
		count = Math.min(count,  64 - count);
		
		min = Math.min(min, count);
	}

}
