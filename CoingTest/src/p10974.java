import java.util.Scanner;

public class p10974 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		perm(arr, output, visited, 0, n, n);
		
		sc.close();
	}

	private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		// TODO Auto-generated method stub
		if (depth == r) {
			print(output, r);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}		
	}

	private static void print(int[] output, int r) {
		// TODO Auto-generated method stub
		for (int i = 0; i < r; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
		
	}

}
