import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			
			int[] arr = new int[10];
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int sum = 0;
			for(int i=1; i<9; i++) {
				sum+=arr[i];
			}
			System.out.printf("#%d %d\n", tc, Math.round(sum/8.0));
				
		} // end of for(testcase)
	} // end of main
} // end of class
