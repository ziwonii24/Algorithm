import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			
			final String grades[] = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			int n = sc.nextInt();	// 학생 수
			int k = sc.nextInt() - 1;	// 학점을 알고싶은 학생의 번호 -1 = 인덱스
			Integer[] total_score = new Integer[n];
			for(int i=0; i<n; i++) {
				int s1 = sc.nextInt();
				int s2 = sc.nextInt();
				int s3 = sc.nextInt();
				
				total_score[i] = s1*35+s2*45+s3*20;
			}
			int k_score = total_score[k];
			Arrays.sort(total_score, Collections.reverseOrder());
//			System.out.println(Arrays.toString(total_score));
			int k_rank = Arrays.asList(total_score).indexOf(k_score);
			System.out.printf("#%d %s\n", tc, grades[10*k_rank/n]);
				
		} // end of for(testcase)
	} // end of main
} // end of class
