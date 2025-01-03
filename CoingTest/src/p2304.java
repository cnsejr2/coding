import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Info {
	int x, y;
	
	public Info(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class p2304 {
	
	static int n, sum;
	static List<Info> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Info(x, y));
		}
		
		Collections.sort(list, (o1, o2) -> o1.x - o2.x);
		
		sum = 0;
		int pivot = 0;
		
		Info com = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			Info cur = list.get(i);
			
			if (com.y <= cur.y) {
				sum += (cur.x - com.x) * com.y;
				com = cur;
				pivot = i;
			}
		}
		com = list.get(list.size() - 1);
		for (int i = 1; i < list.size() - pivot; i++) {
			Info cur = list.get(list.size() - 1 - i);
			
			if (com.y <= cur.y) {
				sum += (com.x - cur.x) * com.y;
				com = cur;
			}
		}
		
		sum += list.get(pivot).y;
		
		System.out.println(sum);
		
		
	}

}
