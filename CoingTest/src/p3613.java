import java.util.Scanner;

public class p3613 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String result = "";
		if (s.contains("_")) { // C++인 경우
			if (s.charAt(s.length() - 1) != '_' || s.indexOf("__") >= 0) {
				String[] str = s.split("_");
				for (int i = 0; i < str.length; i++) {
					String s1 = str[i];
					if (s1.length() > 0) {
						if (Character.isLowerCase(s1.charAt(0))) {
							if (i == 0) {
								result += s1.charAt(0);
							} else {
								result += Character.toUpperCase(s1.charAt(0));	
							}
							result += s1.substring(1, s1.length());	
						} else {
							result = "Error!";
							break;
						}
					} else {
						result = "Error!";
						break;
					}
				}	
			} else {
				result = "Error!";
			}
		} else {
			char ch = s.charAt(0); // 첫 단어는 소문자
			result += ch;
			if (Character.isLowerCase(ch) && !s.contains(" ")) { // Java인 경우
				for (int i = 1; i < s.length(); i++) {
					char c = s.charAt(i);
					if (Character.isUpperCase(c)) {
						result += "_";
					}
					result += Character.toLowerCase(c);
				}
			} else { 
				result = "Error!";
			}
			
		}
		System.out.println(result);
		sc.close();
		
	}

}
