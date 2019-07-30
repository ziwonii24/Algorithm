import java.io.*;
import java.util.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int n;
	
	void solve() {
		try {
			for(int tc=1; tc<=10; tc++) {
				n = Integer.parseInt(br.readLine());
				String str = br.readLine();
				Stack<Integer> stack = new Stack<>();
				
				int mul = 0;
				for(int i=0; i<n; i++) {
					char c = str.charAt(i);
					if(c=='+') {
						continue;
					} else if(c=='*') {
						mul = stack.pop();
					} else {	// 숫자
						int num = c-'0';
						if(mul != 0) {
							mul *= num;
							stack.add(mul);
							mul = 0;
						} else {
							stack.add(num);
						}
					}
				}
				
				int sum = 0;
				for(int s: stack) {
					sum += s;
				}
				sb.append("#").append(tc).append(" ").append(sum).append("\n");
				
			}
		} catch(IOException e) {}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
