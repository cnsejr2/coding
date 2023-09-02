import java.util.Scanner;

public class p1244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 스위치 갯수
		int[] arr = new int[n + 3]; // 스위치 상태
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int s = sc.nextInt(); // 학생 수		
		for (int i = 0; i < s; i++) {
			int gender = sc.nextInt(); // 성별
			int num = sc.nextInt(); // 스위치 번호
			
			for (int j = 1; j <= n; j++) {
				if (gender == 1 && j % num == 0) { // 남자
					arr[j] = (arr[j] < 1 ? 1 : 0); // 스위치 상태 변경
				}
				if (gender == 2 && j == num) { // 여자
					int left = j - 1;
					int right = j + 1;
					arr[j] = (arr[j] < 1 ? 1 : 0); // 스위치 상태 변경
					if (left >= 1 && right <= n) {
						while (arr[left] == arr[right] && left >= 1 && right <= n) {
							arr[left] = (arr[left] < 1 ? 1 : 0); 
							left--;
							arr[right] = (arr[right] < 1 ? 1 : 0); 
							right++;
						}
					}
					break;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
		
		sc.close();
	}

}
