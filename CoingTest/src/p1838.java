import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1838 {

	static int stoi(String s) { return Integer.parseInt(s);}
	 
    static class Pair implements Comparable<Pair> {
        int index;
        long value;
 
        public Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }
 
        public int compareTo(Pair o) {
            return (int) (this.value - o.value);
        }
 
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int n = stoi(br.readLine());
        int max = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            pq.add(new Pair(i, stoi(st.nextToken())));
        }
 
        int idx = 0;
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
 
            if(max < pair.index - idx)
                max = pair.index - idx;
 
            idx++;
        }
 
        System.out.println(max);
    }

}
