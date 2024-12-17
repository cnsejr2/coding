
public class dupPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4};
		int output[] = new int[arr.length];
		boolean[] visited = new boolean[arr.length];
		int n = arr.length;
		
		dupPerm(arr, output, visited, 0, n, 2);
	}

	private static void dupPerm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		// TODO Auto-generated method stub
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			output[depth] = arr[i];
			dupPerm(arr, output, visited, depth + 1, n, r);
			visited[i] = false;
		}
		
	}
	
	

}
