import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p16800 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] arr = new long[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextLong();
		}
		
		for (int i = 1; i <= n; i++) {
			Long min = arr[i] - 1;
			for (long j = 2; j <= Math.sqrt(arr[i]); j++) {
				if (arr[i] % j == 0) {
					if (min > (j + (arr[i] / j) - 2)) {
						min = (j + (arr[i] / j) - 2);
					}
				}
			}
			System.out.println("#" + i + " " + min);
		}
		
		sc.close();
	}

}
