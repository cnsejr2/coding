import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2470 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = n - 1;
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				
				answer[0] = arr[left];
				answer[1] = arr[right];
				
				if (sum == 0) {
					break;
				}
			}
			
			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);

	}

}
