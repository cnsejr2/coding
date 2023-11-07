import java.util.Scanner;

public class p9655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String s = n % 2 == 1 ? "SK" : "CY";
		System.out.println(s);
		
		sc.close();
		
	}

}
