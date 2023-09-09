import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] tall = new int[n + 1];
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			tall[i] = sc.nextInt();
		}
		
		for (int i = n; i >= 1; i--) {
			ans.add(tall[i], i);
		}
		
		for (int k : ans) {
			System.out.print(k + " ");
		}
		
		
		sc.close();
	}

}
