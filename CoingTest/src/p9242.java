import java.util.*;

public class p9242 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[][][] number = {
            // 0
            {
                {'*', '*', '*'},
                {'*', ' ', '*'},
                {'*', ' ', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'}
            },
            // 1
            {
                {' ', ' ', '*'},
                {' ', ' ', '*'},
                {' ', ' ', '*'},
                {' ', ' ', '*'},
                {' ', ' ', '*'}
            },
            // 2
            {
                {'*', '*', '*'},
                {' ', ' ', '*'},
                {'*', '*', '*'},
                {'*', ' ', ' '},
                {'*', '*', '*'}
            },
            // 3
            {
                {'*', '*', '*'},
                {' ', ' ', '*'},
                {'*', '*', '*'},
                {' ', ' ', '*'},
                {'*', '*', '*'}
            },
            // 4
            {
                {'*', ' ', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'},
                {' ', ' ', '*'},
                {' ', ' ', '*'}
            },
            // 5
            {
                {'*', '*', '*'},
                {'*', ' ', ' '},
                {'*', '*', '*'},
                {' ', ' ', '*'},
                {'*', '*', '*'}
            },
            // 6
            {
                {'*', '*', '*'},
                {'*', ' ', ' '},
                {'*', '*', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'}
            },
            // 7
            {
                {'*', '*', '*'},
                {' ', ' ', '*'},
                {' ', ' ', '*'},
                {' ', ' ', '*'},
                {' ', ' ', '*'}
            },
            // 8
            {
                {'*', '*', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'}
            },
            // 9
            {
                {'*', '*', '*'},
                {'*', ' ', '*'},
                {'*', '*', '*'},
                {' ', ' ', '*'},
                {'*', '*', '*'}
            }
        };

        Scanner sc = new Scanner(System.in);
        List<String> code = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            code.add(sc.nextLine());
        }
        
        boolean isWrong = false;
        int sum = 0;
        
        for (int i = 0; i < code.get(0).length(); i += 4) {
        	int n;
        	for (n = 0; n <= 9; n++) {
        		boolean flag = true;
        		int cnt = 0;
        		
        		for (int x = 0; x < 5; x++) {
        			for (int y = 0; y < 3; y++) {
        				if (code.get(x).charAt(i + y) == '*') {
        					cnt++;
        				}
        				if (code.get(x).charAt(i + y) != number[n][x][y]) {
        					flag = false;
        				}
        			}
        		}
        		
        		if (cnt == 0) {
        			break;
        		}
        		
        		if (flag) {
        			sum = sum * 1 + n;
        			break;
        		}
        		        		
        	}
        	if (n == 10) {
        		isWrong = false;
        		break;
        	}
        }
        
        if (sum % 6 != 0 || isWrong) {
            System.out.println("BOOM!!");
        } else {
            System.out.println("BEER!!");
        }
        
	}

}
