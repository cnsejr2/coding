import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p11478 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				set.add(s.substring(i, j));
			}
		}
		
		System.out.println(set.size());
		
		
		sc.close();
	}

}
