import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p1967 {
	static class Node{
		int num;
		int weight;
		
		Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
	static int n;
	static int dist;
	static int farthestNode;
	static ArrayList<Node> adj[];
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		n = Integer.parseInt(st.nextToken());
		dist = 0;
		farthestNode = 0;
		adj = new ArrayList[n + 1];
		isVisited = new boolean[n + 1];
		
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[p].add(new Node(c, w));
			adj[c].add(new Node(p, w));
		}
		
		isVisited[1] = true;
		dfs(1, 0);
		
		isVisited = new boolean[n + 1];
		dist= 0;
		isVisited[farthestNode] = true;
		dfs(farthestNode, 0);
		
		System.out.println(dist);
		
	}

	private static void dfs(int nodeNum, int distSum) {
		// TODO Auto-generated method stub
		if (dist < distSum) {
			dist = distSum;
			farthestNode = nodeNum;
		}
		
		for (Node next : adj[nodeNum]) {
			if(isVisited[next.num]) {
				continue;
			}
			
			isVisited[next.num] = true;
			dfs(next.num,  distSum + next.weight);
		}
	}
}
