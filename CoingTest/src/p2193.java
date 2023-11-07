import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2193 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		long d[] = new long[count + 1];
		
		d[0] = 0;
		d[1] = 1;
		
		for (int i = 2; i <= count; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		
		System.out.println(d[count]);
		
	}

}
