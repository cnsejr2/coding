import java.util.Scanner;

public class p1904 {

	public static int[] dp = new int[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		System.out.println(tile(n));
		
		sc.close();

	}

	private static int tile(int n) {
		// TODO Auto-generated method stub
		if (dp[n] == -1) {
			dp[n]= (tile(n - 1) + tile(n - 2)) % 15746;
		}
		
		return dp[n];
	}

}
