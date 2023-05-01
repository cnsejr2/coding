import java.util.ArrayList;
import java.util.Arrays;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] kor = {"AAA", "BCD", "AAAAA", "ZY" };
		String[] usa = {"AB", "AA", "TTTT" };
		String[] incs = {"AB BCD AA AAA TTTT AAAAA",
							"BCD AAA", "AB AAA TTTT BCD", "AA AAAAA AB",
							"AAA AB BCD"};
		
		int result = check(kor, usa, incs);
		System.out.println(result);
	
		
	}

	private static int check(String[] kor, String[] usa, String[] incs) {
		// TODO Auto-generated method stub
		int answer = 0;
     
		ArrayList<String> korList = new ArrayList<String>(Arrays.asList(kor));
		ArrayList<String> usaList = new ArrayList<String>(Arrays.asList(usa));
		
		int[] cntArr = new int[korList.size() * usaList.size()];
		for (int i = 0; i < cntArr.length; i++) {
			cntArr[i] = 0;
		}
		
		boolean korYn = false; boolean usaYn = false;
		for (int i = 0; i < incs.length; i++) {
			String[] day = incs[i].split(" ");
			for (int j = 0; j < day.length; j++) {
				if (korList.contains(day[j])) {
					korYn = true;
				}
				if (usaList.contains(day[j])) {
					usaYn = true;
				}
				if (korYn == true && usaYn == true) {
					answer++;
					break;
				}
			}

			korYn = false; usaYn = false;
		}
		
		return answer;
	}	

}
