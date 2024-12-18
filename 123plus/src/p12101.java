import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p12101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<String>[] arr = new ArrayList[n + 3];
		for (int i = 0; i <= n + 2; i++) {
			arr[i] = new ArrayList<String>();
		}
		arr[1].add("1"); arr[2].add("1+1"); arr[2].add("2");
		arr[3].add("1+1+1"); arr[3].add("1+2"); arr[3].add("3");
		
		for (int i = 4; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				for (String op : arr[i - j]) {
					arr[i].add(op + "+" + j);
				}
			}
		}
		
		if (arr[n].size() < k) {
			System.out.println(-1);
		} else {
			Collections.sort(arr[n]);
			System.out.println(arr[n].get(k - 1));
		}
		
		
		sc.close();

	}

}
