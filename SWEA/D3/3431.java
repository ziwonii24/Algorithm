import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			int ans = 0;
			if(X>=L && X<=U) ans = 0;
			else if(X<L) ans = L-X;
			else if(X>U) ans = -1;
			
			System.out.printf("#%d %d\n", tc, ans);
				
		} // end of for(testcase)
	} // end of main
} // end of class
