import java.util.Scanner;

public class p11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long D[] = new long[1001];
		// N 이 1일때 타일 채우는 경우의 수
		D[1] = 1;
		D[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			D[i] = (D[i- 1] + D[i - 2]) % 10007;
		}
		
		System.out.print(D[N]);
		
		sc.close();
		
	}

}
