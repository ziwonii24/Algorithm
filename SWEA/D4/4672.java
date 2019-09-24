import java.io.*;
import java.util.*;

/**그리디 (완탐으로 하면 시간초과) + 부분문자열 + */
public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb;
	StringBuilder sb_ans = new StringBuilder();
	int ans = 0;
	
	void palindrome(char[] str) {
		int len = str.length;
		boolean flag = true;
		for(int i=0; i<len/2; i++) {
			if(str[i]!=str[len-i-1]) {
				flag = false;
				break;
			}
		}
		if(flag) 
			ans+=1;
	}
	
	void solve() throws IOException {		
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			ans = 0;
			char[] line = br.readLine().toCharArray();			
			Arrays.sort(line);
			int len = line.length;			
			for(int i=0; i<len; i++) {
				for(int j=i; j<len; j++) {
					sb = new StringBuilder();
					for(int k=i; k<=j; k++) {
						sb.append(line[k]);
					}
					palindrome(sb.toString().toCharArray());
				}
			}
			sb_ans.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb_ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
