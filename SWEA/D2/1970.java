import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			int n = sc.nextInt();	
			
			final int units[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			System.out.printf("#%d\n", tc);
			for(int u: units) {
				System.out.print(n/u + " ");
				n %= u;
			}
			System.out.println();
			
			/*
			// 0	  1	 	 2	   3	 4	 5	 6	7
			// 50,000 10,000 5,000 1,000 500 100 50 10
			int[] arr = new int[8];
			
			arr[0] = n/50000;
			n%=50000;
			arr[1] = n/10000;
			n%=10000;
			arr[2] = n/5000;
			n%=5000;
			arr[3] = n/1000;
			n%=1000;
			arr[4] = n/500;
			n%=500;
			arr[5] = n/100;
			n%=100;
			arr[6] = n/50;
			n%=50;
			arr[7] = n/10;
			
			System.out.printf("#%d\n", tc);
			for(int i=0; i<8; i++) {
				System.out.printf("%d ", arr[i]);				
			}
			System.out.println();
			*/
		} // end of for(testcase)
	} // end of main
} // end of class
