import java.util.Arrays;
import java.util.Scanner;

public class p16435 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			if (l >= arr[i]) {
				++l;
			}
		}
		
		System.out.println(l);
		
		
		
		sc.close();
	}

}
