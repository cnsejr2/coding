import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14889 {

	static int n;
	static int[][] map;
	static boolean[] visit;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0, 0);
		
		System.out.println(Min);
		
		
	}

	// index는 인덱스, count는 조합개수(= 재귀깊이)
	private static void combi(int index, int count) {
		// 팀 조합이 완성될 경우
		if (count == n / 2) {
			// 방문한 팀과 방문하지 않은 팀을 각각 나누어
			// 각 팀의 점수를 구한 뒤 최솟값을 갖는다.
			diff();
			return;
		}
		
		for (int i = index; i < n; i++) {
			// 방문하지 않은 경우
			if (!visit[i]) {
				visit[i] = true; // 방문으로 변경
				combi(i + 1, count + 1); // 재귀 호출
				visit[i] = false; // 재귀가 끝나면 비방문으로 변경
			}
		}
	}

	private static void diff() {
		// TODO Auto-generated method stub
		int teamStart = 0;
		int teamLink = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				// i번째 사람과 j번째 사람이 true라면 스타트팀으로 점수 플러스
				if (visit[i] == true && visit[j] == true) {
					teamStart += map[i][j];
					teamStart += map[j][i];
				} 
				// i번째 사람과 j번째 사람이 false라면 링크팀으로 점수 플러스
				else if (visit[i] == false && visit[j] == false) {
					teamLink += map[i][j];
					teamLink += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이(절대값)
		int val = Math.abs(teamStart - teamLink);
		
		// 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		// 탐색 종료
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		Min = Math.min(val,  Min);
		
	}

}
