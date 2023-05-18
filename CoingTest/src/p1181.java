import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class p1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n  = sc.nextInt();
		
		List<String> line = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (!line.contains(s)) { 
				line.add(s);
			}
		}
		
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				if(s1.length() == s2.length()) {
	   	 			return s1.compareTo(s2);
	   	 		}else {
	   	 			return s1.length() - s2.length();
	   	 		}
			}
			
		};
		
		Collections.sort(line, c);
		
		for (String s : line) {
			System.out.println(s);
		}
		sc.close();
	}

}
