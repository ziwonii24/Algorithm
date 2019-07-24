import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int N=0; N<n; N++) {
			
			String ps = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;
			for(int i=0; i<ps.length(); i++) {
				char x = ps.charAt(i);
				if(x=='(') {
					stack.push(x);
				} else {	// ')'
					if(stack.isEmpty()) {
						flag = false;
						break;
					} else {
						stack.pop();
					}					
				}
			}
			
			if(!stack.isEmpty()) {
				flag = false;
			}
			
			if(flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		} // end of for(N)		
	} // end of main
} // end of class
