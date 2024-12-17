import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20116 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] x = new int[n]; // 박스들의 x좌표
		int[][] distance = new int[n][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
			distance[i][0] = x[i] - l;
			distance[i][1] = x[i] + l;
		}
		int flag = 0;
		int sum = 0;
		for (int i = n - 1; i > 0; i--) {
			sum += x[i];
			double avg = (double) sum / (n - i);
			if (avg <= x[i - 1] - l || avg >= x[i - 1] + l) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.println("unstable");
		} else {
			System.out.println("stable");
		}
		
		
		
	}

}
