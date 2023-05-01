import java.util.Scanner;

public class p11049 {

	static int N;
	static Matrix[] M;
	static int[][] D;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = new Matrix[N + 1];
		D = new int[N + 1][N + 1];
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				D[i][j] = -1;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			M[i] = new Matrix(y, x);
		}
		System.out.println(execute(1, N));
		
		
		sc.close();
	}
	static int execute(int s, int e) {
		int result = Integer.MAX_VALUE;
		
		if (D[s][e] != -1) { // 이미 계산되어 있는 경우
			return D[s][e];
		} else if (s == e) { // 행렬 한 개
			return 0;
		} else if (s + 1 == e) { // 행렬 두 개
			return M[s].y * M[s].x * M[e].x;
		} else { // 행렬이 3개 이상일 때
			for (int i = s; i < e; i++) {
				int a = M[s].y * M[i].x * M[e].x;
				// D[s][e] = D[s][i] + S[i + 1][e] + a;
				result = Math.min(result, execute(s, i) + execute(i + 1, e) + a);
			}
		}
		
		return D[s][e] = result;
	}
	static class Matrix{
		private int x;
		private int y;
		
		Matrix(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}

