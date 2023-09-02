import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p1205 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int score = sc.nextInt();
		int p = sc.nextInt();
		
		Integer[] rankList = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			rankList[i] = sc.nextInt();
		}
		
		int rank = 1;
		
		Arrays.sort(rankList, Collections.reverseOrder());
		
		if (n == p && score <= rankList[rankList.length - 1]) {
			System.out.println("-1");
		} else {
			for (int i = 0; i < rankList.length; i++) {
				if (score < rankList[i]) {
					rank++;
				} else {
					break;
				}
			}
			System.out.println(rank);
		}
		
		
		
		sc.close();
	}

}
