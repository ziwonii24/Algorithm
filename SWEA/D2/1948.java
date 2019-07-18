import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			
			int mon1 = sc.nextInt();
			int day1 = sc.nextInt();
			int mon2 = sc.nextInt();
			int day2 = sc.nextInt();
			
			int sum = 1;
			for(int m=mon1; m<mon2; m++) {
				switch(m) {
				case 2:
					sum += 28;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum += 30;
					break;
				default:
					sum += 31;
					break;
				}		
			}
			sum = sum - day1 + day2;
			System.out.printf("#%d %d\n", tc, sum);
			
		}
	}
}
