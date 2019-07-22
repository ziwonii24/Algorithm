import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			int ans = 0;
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					arr[i][j] = sc.nextInt();

			for(int i=0; i<n-m+1; i++) {
				for(int j=0; j<n-m+1; j++) {
					int sum = 0;
					for(int mi=i; mi<i+m; mi++) {
						for(int mj=j; mj<j+m; mj++) {
							sum += arr[mi][mj];
						}
					}
					if(ans < sum) ans = sum;
				}
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
		} // end of for(testcase)
	} // end of main
} // end of class
