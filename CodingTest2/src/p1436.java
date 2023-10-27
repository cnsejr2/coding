import java.util.Scanner;

public class p1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = 666;
		int count = 1;
		
		while (count != N) {
			num++;
			if (String.valueOf(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
		sc.close();
		
		
		sc.close();
	}

}
