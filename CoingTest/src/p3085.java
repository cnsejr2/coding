import java.util.Scanner;

public class p3085 {
	static char[][] board; // 맵 크기
	static int n;
	static int max = 0;

	public static void swap(char a, char b) {
		char temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		board = new char[n][n];
		
		// 사탕 입력
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		// 가로로 인접한 두 사탕 교환 후, 최대 사탕 개수 찾고 원 위치
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				// 가로로 인접한 두 문자 교환
				char temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
				
				// →, ↓ 체크
				arrCheck();
				
				// 이전에 교환한 문자 복구
				//swap(board[i][j], board[i][j+1]);
				temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
			}
		}
		
		// 세로로 인접한 두 사탕 교환 후, 최대 사탕 개수 찾고 원 위치
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				char temp = board[j][i];
				board[j][i] = board[j+1][i];
				board[j+1][i] = temp;
				
				// →, ↓ 체크
				arrCheck();
				
				// 이전에 교환한 문자 복구
				//swap(board[j][i], board[j+1][i]);
				temp = board[j][i];
				board[j][i] = board[j+1][i];
				board[j+1][i] = temp;
			}
		}
		
		System.out.println(max);
		sc.close();
	}
	// 행, 열을 비교하며 먹을 수 있는 사탕의 최대 갯수 찾기
	private static void arrCheck() {
		// TODO Auto-generated method stub
		// 가로를 확인
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = 0; j < n - 1; j++) {
				// 이전 사탕과 동일한 경우 -> 계속 먹는다
				if(board[i][j] == board[i][j+1])
					count ++;
				
				// 이전과 다른 사탕인 경우 -> 새로 먹어야하므로 1로 초기화
				else 
					count = 1;
				
				// 사탕 최대 개수 저장
				max = Math.max(max, count);
			}
		}
		
		// 세로를 확인
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = 0; j < n - 1; j++) {
				if(board[j][i] == board[j+1][i])
					count ++;
				else 
					count = 1;
				max = Math.max(max, count);
			}
		}
	}

}
