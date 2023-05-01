import java.util.Scanner;

public class p11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 그리드 알고리즘 -> 최대한 큰 동전 먼저 사용하기
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] <= k) {
				count += (k / arr[i]);
				k = k % arr[i];
			}
		}
		System.out.println(count);
		
		sc.close();
	}
	

}
