import java.util.Scanner;

public class p11050 {

	static int N, K;
	static int DP[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		DP = new int[N + 1][N + 1];
		//초기화
		for (int i = 0; i <= N; i++) {
			DP[i][i] = 1;
			DP[i][0] = 1;
			DP[i][1] = i;
		}
		
		// 점화식으로 배열 완성하기
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1];
			}
		}
		System.out.print(DP[N][K]);
		
		sc.close();
	}

}
