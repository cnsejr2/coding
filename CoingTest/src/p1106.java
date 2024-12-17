import java.util.Arrays;
import java.util.Scanner;

public class p1106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int n = sc.nextInt();
		int[] dp = new int[c + 101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 0; i < n; i++) {
			int cost = sc.nextInt();
			int people = sc.nextInt();
			
			for (int j = people; j < c + 101; j++) {
				dp[j] = Math.min(dp[j], cost + dp[j - people]);
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = c; i < c + 101; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);
		sc.close();
	}

}
