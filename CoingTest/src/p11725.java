import java.util.ArrayList;
import java.util.Scanner;

public class p11725 {
	static int n;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int[] parents;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new ArrayList[n + 1];
		parents = new int[n + 1];
		
		for (int i = 1; i <= n ; i++) {
			map[i] = new ArrayList<Integer>();
		}
		visited = new boolean[n + 1];
		for (int i = 1; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x].add(y);
			map[y].add(x);
		}
		for (int i = 1; i <= n;  i++) {
			if (visited[i] == false) {
				dfs(i);
			}
		}
		
		for (int i = 2; i <= n; i++) {
			System.out.println(parents[i]);
		}
		
		sc.close();
	}
	private static void dfs(int x) {
		// TODO Auto-generated method stub
		visited[x] = true;
		
		for (int i : map[x]) {
			if (visited[i] == false) {
				parents[i] = x;
				dfs(i);
			}
		}
	
	}

}
