import java.util.Scanner;

public class p17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n + 1];
		dp[1] = 1;
	
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				int temp = i - j * j;
				min = Math.min(min, dp[temp]);
			}
			dp[i] = min + 1;
		}
		
		System.out.println(dp[n]);
		sc.close();
		

	}

}
