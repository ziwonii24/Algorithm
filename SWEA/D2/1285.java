import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			int ans = 0;
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			int min_diff = 100000;
			int cnt = 0;
			for(int i=0; i<n; i++) {
				int num = sc.nextInt();
				if(num < 0) 
					num = -num;
				if(num == min_diff) {
					cnt++;
				} else if(num < min_diff) { 
					min_diff = num;
					cnt = 1;
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, min_diff, cnt);			
		} // end of for(testcase)
	} // end of main
} // end of class
