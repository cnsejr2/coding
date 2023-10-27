
public class dupCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4};
		int output[] = new int[arr.length];
		boolean visited[] = new boolean[arr.length];
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			dupComb(arr, output, visited, 1, n, i + 1, 0);
		}
	}

	private static void dupComb(int[] arr, int[] output, boolean[] visited, int start, int n, int r, int cnt) {
		// TODO Auto-generated method stub
		if (cnt == r) {
			for (int i = 0; i < cnt; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start - 1; i < n; i++) {
			visited[i] = true;
			output[cnt] = arr[i];
			dupComb(arr, output, visited, i + 1, n, r, cnt + 1);
			visited[i] = false;
		}
	}

}
