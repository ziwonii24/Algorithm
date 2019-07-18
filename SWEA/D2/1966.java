import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			System.out.printf("#%d", tc);
			for(int item : arr) {
				System.out.printf(" %d", item);
			}
			System.out.println();
			
		}
	}
}
