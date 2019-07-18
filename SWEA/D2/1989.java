import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			
			boolean check = true;
			String str = sc.next();
			int limit = str.length()%2==0 ? str.length()/2 : str.length()/2+1;
			for(int i=0; i<limit; i++) {
				if(str.charAt(i) != str.charAt(str.length()-1-i)) {
					check = false;
				}
			}
			System.out.printf("#%d %d\n", tc, check?1:0);
			
			
		}
	}
}
