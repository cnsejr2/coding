import java.util.Scanner;

public class p2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		while (true) {
			if (n % 5 == 0) {
				System.out.println(n / 5 + cnt);
				break;
			} else if (n < 0) {
				System.out.println("-1");
			}
			n = n - 3;
			cnt++;
		}
		
		sc.close();
	}

}
