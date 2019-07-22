import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int testcase = sc.nextInt();
			int ans = 0;
			
			int[][] arr = new int[100][100];
			int destination = 0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j]==2) 
						destination = j;
				}
			}
			
			int x = 99;
			int y = destination;
			while(x != 0) {
				boolean flag = false;
				while (y>0 && arr[x][y-1]==1) {						
					y-=1;
					flag = true;
				}
				if(!flag) {
					while (y<99 && arr[x][y+1]==1) {						
						y+=1;
					}
				}
				x--;
			}
			
			System.out.printf("#%d %d\n", tc, y);
		} // end of for(testcase)		
	} // end of main
} // end of class
