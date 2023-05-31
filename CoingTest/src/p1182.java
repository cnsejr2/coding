import java.util.Scanner;

public class p1182 {

	static int n, s;
	static int[] arr;
	static int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		
		System.out.println(ans);
		
		
		sc.close();
	}
	private static void dfs(int i, int cnt) {
		if (i == n) {
			return;
		} else {
			if (arr[i] + cnt == s) {
				ans++;
			}
			dfs(i + 1, cnt);
			dfs(i + 1, cnt + arr[i]);
		}
	}

}
