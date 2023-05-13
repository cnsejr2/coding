import java.util.Scanner;

public class p1789 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long num = 0;
		long count = 0;
		long n = 1;
		while (true) {
			if (num > s) {
				break;
			}
			num += n;
			n++;
			count++;
			
		}
		
		System.out.println(count - 1);
		sc.close();
	}

}
