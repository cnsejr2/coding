import java.util.Scanner;

public class p16910 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int result = calculate(n);
			System.out.println("#" + i + " " + result);
		}
		sc.close();
	}

	private static int calculate(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n; j++) {
				if (Math.pow(i, 2) + Math.pow(j, 2) <= Math.pow(n,  2)) {
					count++;
				}
			}
		}
		
		count *= 4;
		
		count = count + 1 + n * 4;
		return count;
	}

}
