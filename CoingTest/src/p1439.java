import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1439 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		
		int answer = 0;
		int index = 1;
		
		if (data.length() > 0) {
			char std = data.charAt(0);
			
			while (index < data.length()) {
				if (data.charAt(index) == std) {
					index++;
					continue;
				}
				
				answer++;
				for (int i = index; i < data.length(); i++) {
					if (data.charAt(index) == std) {
						break;
					}
					index++;
				}
			}
		}
		System.out.println(answer);

	}

}
