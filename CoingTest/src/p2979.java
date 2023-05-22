import java.util.Scanner;

public class p2979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] price = new int[4];
		for (int i = 1; i <= 3; i++) {
			price[i] = sc.nextInt();
		}
		int[] park = new int[101];
		int minS = 101;
		int maxE = 0;
		for (int i = 1; i <= 3; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if (start < minS) { minS = start;}
			if (end > maxE) { maxE = end; }
			for (int s = start; s < end; s++) {
				park[s]++;
			}
		}
		int sum = 0;
		
		for (int i = minS; i < maxE; i++) {
			if (park[i] == 1) {
				sum += price[1];
			} else if (park[i] == 2) {
				sum += (price[2] * 2);
			} else if (park[i] == 3) {
				sum += (price[3]* 3);
			}
		}
		System.out.println(sum);
		
		sc.close();
	}

}
