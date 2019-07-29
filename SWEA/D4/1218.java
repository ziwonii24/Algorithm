import java.io.*;
import java.util.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int n;
	Stack<Character> stack = new Stack<>();
	
	void solve() {
		for(int tc=1; tc<=10; tc++) {
			try {
				n = Integer.parseInt(br.readLine());
				String str = br.readLine();
				boolean flag = true;
				stack.clear();
				
				for(int i=0; i<n; i++) {
					char c = str.charAt(i);
					if(c=='(' || c=='[' || c=='{' || c=='<') {
						stack.add(c);
					} else if (c==')'){
						if(stack.isEmpty()) {
							flag = false;
							break;
						}
						if(stack.peek()=='(') {
							stack.pop();
						} else {
							flag = false;
							break;
						}
					} else if (c==']'){
						if(stack.isEmpty()) {
							flag = false;
							break;
						}
						if(stack.peek()=='[') {
							stack.pop();
						} else {
							flag = false;
							break;
						}
					} else if (c=='}'){
						if(stack.isEmpty()) {
							flag = false;
							break;
						}
						if(stack.peek()=='{') {
							stack.pop();
						} else {
							flag = false;
							break;
						}
					} else if (c=='>'){
						if(stack.isEmpty()) {
							flag = false;
							break;
						}
						if(stack.peek()=='<') {
							stack.pop();
						} else {
							flag = false;
							break;
						}
					}
				}
				
				if(!stack.isEmpty()) {
					flag = false;
				}
				
				sb.append("#").append(tc).append(" ");
				if(flag) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				
			} catch(IOException e) {}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
