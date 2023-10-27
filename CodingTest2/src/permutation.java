
public class permutation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4};
		int[] output = new int[arr.length];
		boolean visited[] = new boolean[arr.length];
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			perm(arr, output, visited, 0, n, i + 1);	
		}
		
		
	}

	private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		// TODO Auto-generated method stub
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for  (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

}
