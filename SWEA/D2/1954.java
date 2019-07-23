import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			int step = n-1;
			int r=0;
			int c=0;
			int val = 1;
			 
			while(step > 0) {
				for(int i=0; i<step; i++) {
					arr[r][c] = val++;
					c++;
				}
				for(int i=0; i<step; i++) {
					arr[r][c] = val++;
					r++;
				}
				for(int i=0; i<step; i++) {
					arr[r][c] = val++;
					c--;
				}
				for(int i=0; i<step; i++) {
					arr[r][c] = val++;
					r--;
				}
				step-=2;
				r++;
				c++;
			}
			
			if(val == n*n) {
				arr[r][c] = val;
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		} // end of for(testcase)		
	} // end of main	
} // end of class
