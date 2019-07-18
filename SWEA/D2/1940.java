import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			
			int n = sc.nextInt(); 	// command 수			
			int time = 0;	// 시간
			int sum = 0;	// 총 이동거리
			int v = 0;		// rc카의 속도
			while(time < n) {
				time++;
				int command = sc.nextInt();	// 0: 유지, 1: 가속, 2: 감속
				int av = 0;
				if(command != 0) {
					av = sc.nextInt();		// 가속도
				}
				
				if(command == 1) {
					v += av;
				} else if(command == 2) {
					if(v <= av) {
						v = 0;
					} else {
						v -= av;
					}
				}
				sum += v;
			}			
			System.out.printf("#%d %d\n", tc, sum);
			
		} // end of for(testcase)
	} // end of main
} // end of class
