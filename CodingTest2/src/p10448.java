import java.util.Scanner;

public class p10448 {
	static int[] t = new int[46];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		for (int i = 1; i < 45; i++) {
			t[i] = i * (i + 1) / 2;
		}
		
		for (int i = 0; i < k; i++) {
			int n = sc.nextInt();
			
			System.out.println(calculate(n));
		}
		
		sc.close();
	}
	private static int calculate(int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 45; i++) {
			for (int j = 1; j < 45; j++) {
				for (int k = 1; j < 45; k++) {
					if (n == (t[i] + t[j] + t[k])) {
						return 1;
					}
				}
			}
		}
		
		return 0;
	}

}
