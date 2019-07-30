import java.io.*;
import java.util.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int testcase;
	Stack<Character> stack = new Stack<>();
	
	void solve() {
		try {
			testcase = Integer.parseInt(br.readLine());
			for(int tc=1; tc<=testcase; tc++) {
				String str = br.readLine();
				char tmp = ' ';
				int cnt = 0;
				for(int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					if(c=='(') {
						tmp = '(';
						stack.add('(');
					} else {
						stack.pop();
						if(tmp=='(') {
							cnt += stack.size();
						} else {
							cnt += 1;
						}
						tmp = ')';
					}
				}
				sb.append('#').append(tc).append(" ").append(cnt).append("\n");
			}
			System.out.println(sb);
			
		} catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
