import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1325 {
	static int n;
	static int m;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int[] result;
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		result = new int[n + 1];
		
		for (int i = 1; i <= n ; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[b].add(a);
		}
		
		for (int i = 1; i <= n; i++) {
			count = 0;
			dfs(i);
			result[i] = count;
			visited = new boolean[n + 1];
		}	
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < result[i]) {
				max = result[i];
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (max == result[i]) {
				System.out.print(i + " ");
			}
		}
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		
		for (int j : map[i]) {
			if (visited[j] == false) {
				count++;
				dfs(j);
			}
		}

	}

}
