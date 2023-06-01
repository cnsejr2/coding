import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2529 {
	static boolean[] visited;
	static int n;
	static char[] sign;
	static ArrayList list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		visited = new boolean[10];
		sign = new char[n + 1];
		
		for (int i = 0; i < n; i++) {
			sign[i] = sc.next().charAt(0);
		}

		calculate(0, "");
		
		Collections.sort(list);
		
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
		
		sc.close();
	}
	private static void calculate(int index, String num) {
		// TODO Auto-generated method stub
		if (index == n + 1) {
			list.add(num);
			return;
		} 
		
		for (int i = 0; i <= 9; i++) {
			if (index == 0 || !visited[i] && compare(num.charAt(num.length() - 1) - '0', i, sign[index - 1])) {
				visited[i] = true;
				calculate(index + 1, num + Integer.toString(i));
				visited[i] = false;
			}
		}
	}
	private static boolean compare(int a, int b, char s) {
		// TODO Auto-generated method stub
		if (s == '<') {
			return a < b;
		}
		return a > b;
	}
	

}
