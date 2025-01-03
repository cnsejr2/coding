import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p18429 {
	
	static int n, k;
	static int[] arr;
	static boolean[] visit;
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		visit = new boolean[n];
		ans = 0;
		back(500, 0);
		System.out.println(ans);

	}

	private static void back(int sum, int idx) {
		// TODO Auto-generated method stub
		if (idx == n) {
			ans++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visit[i] && (sum + arr[i] - k) >= 500) {
				visit[i] = true;
				back(sum + arr[i] - k, idx + 1);
				visit[i] = false;
			}
		}
	}

}
