import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p13023 {
	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		
		for (int i = 0; i < n ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, 1);
			if (result > 0) {
				break;
			}
		}
		
		System.out.println(result);
	}
	private static void dfs(int i, int cnt) {
		// TODO Auto-generated method stub
		if (cnt == 5) {
			result = 1;
			return;
		}
		visited[i] = true;
		for (int a : list[i]) {
			if (!visited[a]) {
				dfs(a, cnt + 1);
			}
		}
		visited[i] = false;
	}

}
