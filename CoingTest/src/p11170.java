import java.util.Scanner;

public class p11170 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int cnt = 0;
			for (int j = n; j <= m; j++) {
				String str = String.valueOf(j);
				cnt += str.length() - str.replace(String.valueOf("0"), "").length();
			}
			System.out.println(cnt);
			
		}
		
		sc.close();

	}

}
