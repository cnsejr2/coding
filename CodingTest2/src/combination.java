
public class combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4};
		int output[] = new int[arr.length];
		boolean visited[] = new boolean[arr.length];
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			comb(arr, output, visited, 0, n, i + 1);
		}
	}

	private static void comb(int[] arr, int[] output, boolean[] visited, int start, int n, int r) {
		// TODO Auto-generated method stub
		if (r == 0) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(arr, output, visited, i + 1, n, r - 1);
				visited[i] = false;
			}
		}
	}

}
