import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p20055 {
	
	static int n;
	static int k;
	static int[] a;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[2 * n];
		robot = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(simulation(0) + "\n");
		
		
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static int simulation(int cnt) {
		// TODO Auto-generated method stub
		while (isOk()) {
			int temp = a[a.length - 1]; // 1. 벨트 한 칸 회전
			for (int i = a.length - 1; i > 0; i--) { 
				a[i] = a[i - 1];
			}
			a[0] = temp;
			
			for (int i = robot.length - 1; i > 0; i--) { // 로봇도 벨트와 같이 회전
				robot[i] = robot[i - 1];
			}
			robot[0] = false;
			
			robot[n - 1] = false;
			for (int i = n - 1; i > 0; i--) { // 2. 로봇 이동가능하면 이동
				if (robot[i - 1] && !robot[i] && a[i] >= 1) {
					robot[i] = true;
					robot[i - 1] = false;
					a[i]--;
				}
			}
			
			if (a[0] > 0) { // 3. 올라가는 위치에 로봇 올리기
				robot[0] = true;
				a[0]--;
			}
			cnt++;
		}	
		
		return cnt;
	}

	private static boolean isOk() {
		int cnt = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				cnt++;
			}
			if (cnt >= k) {
				return false;
			}
		}
		return true;
	}

}
