import java.util.Arrays;
import java.util.Scanner;

public class p1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] timeTable = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			timeTable[i][0] = sc.nextInt();
			timeTable[i][1] = sc.nextInt();
		}
		Arrays.sort(timeTable, (a, b) -> {
			if (a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});
		
		int ans = 0;
		int time = 0;
		
		for (int i = 0; i < n; i++) {
			if (timeTable[i][0] >= time) {
				time = timeTable[i][1];
				ans++;
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}
