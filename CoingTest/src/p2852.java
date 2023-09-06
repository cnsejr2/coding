import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Record {
	int team;
	int time;
	
	public Record(int team, int time) {
		this.team = team;
		this.time = time;
	}
}

public class p2852 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int winTeam;
		int minTime;
		int[] score = {0, 0};
		int[] ansTime = {0, 0};
		Record[] records = new Record[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			winTeam = Integer.parseInt(st.nextToken());
			String tmp = st.nextToken();
			String[] time = tmp.split(":");
			minTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
			records[i] = new Record(winTeam,  minTime);
		}

		winTeam = records[0].team;
		score[winTeam - 1] += 1;
		minTime = records[0].time;
		
		for (int i = 1; i < n; i++) {
			int tmpTeam = records[i].team;
			int tmpTime = records[i].time;
			
			if (score[0] > score[1]) {
				ansTime[0] += (tmpTime - minTime);
			}
			if (score[0] < score[1]) {
				ansTime[1] += (tmpTime - minTime);
			}
			score[tmpTeam - 1] += 1;
			
			minTime = tmpTime;
			
		}
		
		if (score[0] > score[1]) {
			ansTime[0] += (48 * 60 - minTime);
		}
		if (score[0]< score[1]) {
			ansTime[1] += (48 * 60 - minTime);
		}
		
		for (int i = 0; i < 2; i++) {
			int h = ansTime[i] / 60;
			int m = ansTime[i] % 60;
			String hour;
			String min;
			
			if (h < 10) {
				hour = "0" + Integer.toString(h);
			} else {
				hour = Integer.toString(h);
			}
			
			if (m < 10) {
                min = "0" + Integer.toString(m);
            }else {
                min = Integer.toString(m);
            }

            System.out.println(hour + ":" + min);
		}
		
		
	}

}
