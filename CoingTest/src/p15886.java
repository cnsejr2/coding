import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15886 {
	static char[] wordArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < tc; i++) {
			String word = br.readLine();
			wordArr = word.toCharArray();
			
			if (perm()) {
				for (int j = 0; i < word.length(); j++) {
					sb.append(wordArr[i]);
				}
				sb.append("\n");
			} else sb.append(word + "\n");
			
		}
		System.out.println(sb);
	}

	private static boolean perm() {
		// TODO Auto-generated method stub
		int i = wordArr.length - 1;
		while (i > 0 && wordArr[i - 1] >= wordArr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		
		int j = wordArr.length - 1;
		while (wordArr[i - 1] >= wordArr[j]) {
			j--;
		}
		
		char temp = wordArr[i - 1];
		wordArr[i - 1] = wordArr[j];
		wordArr[j] = temp;
		
		int k = wordArr.length - 1;
		while (i < k) {
			temp = wordArr[i];
			wordArr[i] = wordArr[k];
			wordArr[k] = temp;
			i++;
			k--;
		}
		return true;
		
	}

}
