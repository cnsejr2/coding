import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		int[] arr2 = new int[2];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		boolean find = false;
		Arrays.sort(arr);
		for (int i = 0; i < 9; i++) {
			arr2[0] = arr[i];
			for (int j = (i + 1); j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr2[1] = arr[j];
					find = true;
					break;
				}
			}
			if (find) { break; }
			
		}
		
		for (int i = 0; i < 9; i++) {
			if (arr[i] != arr2[0] && arr[i] != arr2[1]) { 
				System.out.println(arr[i]);
			}
		}
		
		
		
		sc.close();
	}

}
