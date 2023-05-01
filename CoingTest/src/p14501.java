import java.util.Scanner;

public class p14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] D = new int[N + 2];
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for (int i = N; i > 0; i--) {
			// 오늘 날짜부터 걸리는 시간이 퇴사일보다 크면 일 불가
			if (i + T[i] > N + 1) {
				D[i] = D[i + 1];
			} else {
				D[i] = Math.max(D[i + 1], D[i +T[i]] +P[i]);
			}
		}
		
		System.out.println(D[1]);
		
		sc.close();
	}

}
