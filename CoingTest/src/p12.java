import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p12 {
	static boolean visited[];
	static ArrayList<Integer>[] arr;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		arr = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}
		int count = 0;
		
		for (int i = 1; i < n; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}


	private static void DFS(int v) {
		// TODO Auto-generated method stub
		if (visited[v]) {
			return;
		} 
		visited[v] = true;
		for (int i : arr[v]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

}
