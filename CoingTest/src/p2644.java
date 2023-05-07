import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2644 {
	
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int result = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 1; i < n+ 1; i++) {
			map[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[p].add(c);
			map[c].add(p);
		}
		
		dfs(x, y, 0);
		System.out.println(result);
	}
	private static void dfs(int s, int e, int cnt) {
		// TODO Auto-generated method stub
		if (s == e) {
			result = cnt;
			return;
		}
		
		visited[s] = true;
		
		for (int i = 0; i < map[s].size(); i++) {
			int next = map[s].get(i);
			if (visited[next] == false) {
				dfs(next, e, cnt + 1);
			}
		}
	}

}
