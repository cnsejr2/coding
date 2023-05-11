import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463 {
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[]= new int[n + 1];
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1]  +  1;
			if (i % 2 == 0) { dp[i] = Math.min(dp[i], dp[i / 2] + 1); }
			if (i % 3 == 0) { dp[i]  = Math.min(dp[i], dp[i / 3] + 1);}
		}
		
		System.out.println(dp[n]);
	}
}
