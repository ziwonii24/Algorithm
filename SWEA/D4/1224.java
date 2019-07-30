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
				Stack<Character> stack = new Stack<>();
				String postfix = "";
				
				for(char c: str.toCharArray()) {
//					char c = str.charAt(i);
//					System.out.println("c="+c);
					switch (c) {
	                case '(': // 넣을때는 3, 무조건 넣음
	                    stack.add(c);
	                    break;
	                case '*': // 넣을때 2
	                    while(!stack.isEmpty() && stack.peek() == '*') {
//	                        System.out.print(stack.pop());
	                    	postfix += stack.pop();
	                    }
	                    stack.add(c);
	                    break;
	                case '+': // 넣을때 1
	                    while(!stack.isEmpty() && stack.peek() != '(') {
//	                        System.out.print(stack.pop());
	                    	postfix += stack.pop();
	                    }
	                    stack.add(c);
	                    break;    
	                case ')': // '('나올때까지 모두 빼서 출력
	                    while (!stack.isEmpty() && stack.peek() != '(') {
//	                        System.out.print(stack.pop() + " ");
	                    	postfix += stack.pop();
	                    }
	                    if (stack.peek() == '(') { // 여는괄호가 남아있으면
	                        stack.pop();
	                    }
	                    break;
	                default: // 숫자 : 바로 출력
//	                    System.out.print(c + " ");
                    	postfix += c;
	                    break;
	                }
				}
				
				// 스택에 남아있는 연산자가 있으면 출력
				while(!stack.isEmpty()) {
//					System.out.print(stack.pop() + " ");
                	postfix += stack.pop();
				}
				
//				System.out.println(postfix);
				
				Stack<Integer> stack_final = new Stack<>();
				for(char c: postfix.toCharArray()) {
					switch(c) {
						case '+':
							int a = stack_final.pop();
							int b = stack_final.pop();
							stack_final.add(a+b);
							break;
						case '*':
							int cc = stack_final.pop();
							int d = stack_final.pop();
							stack_final.add(cc*d);
							break;
						default:
							stack_final.add(c-'0');
							break;
					}
				}
				sb.append("#").append(tc).append(" ").append(stack_final.pop()).append("\n");
			}
		} catch(IOException e) {}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
