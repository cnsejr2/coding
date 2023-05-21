import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			String t = st.nextToken();
			
			String S = s;
			String T = t;
			
			int sLength = s.length();
			int tLength = t.length();
			
			if (sLength != tLength) {
				int len = lcm(sLength, tLength);
				
				while (S.length() != len) {
					S += s;
				}
				
				while (T.length() != len) {
					T += t;
				}
			}
			
			
			if (S.equals(T)) {
				System.out.println("#" + i + " " + "yes");
			} else {
				System.out.println("#" + i + " " + "no");
			}
		}
	}

	private static int lcm(int a, int b) {
		// TODO Auto-generated method stub
		return (a * b) / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		while ( b > 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		return a;
	}

}
