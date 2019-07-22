import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			int n = sc.nextInt();			
			int[][] pascal = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<i+1; j++) {
					if(i==j) pascal[i][j] = 1;
					else if(j==0) pascal[i][j] = 1;
					else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
			
			System.out.printf("#%d\n", tc);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(pascal[i][j]!=0)
						System.out.printf("%d ", pascal[i][j]);
				}
				System.out.println();
			}
			
			
//			System.out.printf("#%d %d %d\n", tc, );			
		} // end of for(testcase)
	} // end of main
} // end of class
