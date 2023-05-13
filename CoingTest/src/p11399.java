import java.util.Arrays;
import java.util.Scanner;

public class p11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int prev = 0; // 이전까지의 대기시간 누적
		int sum = 0; // 사람별 대기시간
		
		for (int i = 0; i < n; i++) {
			sum += prev + arr[i];
			
			prev += arr[i];
		}
		
		System.out.println(sum);
		
		sc.close();

	}

}
