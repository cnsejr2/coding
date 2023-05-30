import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2503 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] s = new String[n];
		int[][] info = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = st.nextToken();
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i = 123; i <= 987; i++) {
			
			int first = i / 100;
			int second = (i % 100) / 10;
			int third = (i % 100) % 10;
			
			if (first != second && second != third && third != first
				&& first != 0 && second != 0 && third != 0 ) {
				boolean flag = true;
				for (int j = 0; j < n; j++) {
					int strike = 0;
					int ball = 0;
					
					String str = s[j];
					
					if (str.charAt(0) - '0' == first) 
						strike++;
					if (str.charAt(1) - '0' == second) 
						strike++;
					if (str.charAt(2) - '0' == third) 
						strike++;
					if (str.charAt(0) - '0' == second || str.charAt(0) - '0' == third) 
						ball++;
					if (str.charAt(1) - '0' == first || str.charAt(1) - '0' == third) 
						ball++;
					if (str.charAt(2) - '0' == second || str.charAt(2) - '0' == first) 
						ball++;
					if (strike != info[j][0] || ball != info[j][1]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
		br.close();
	}

}
