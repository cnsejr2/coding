import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1058 {
	
	static final int INF = 100000000;
	static int[][] cost = new int[51][51];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				cost[i][j] = str[j - 1] == 'Y' ? 1 : INF;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (j == k) {
						continue;
					}
					cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (cost[i][j] == 2 || cost[i][j] == 1) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}

}
