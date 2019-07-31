import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int n;
	Stack<Pair> stack = new Stack<>();
	int[] ans;
	Pair p;
	
	void solve() {
		try {
			n = Integer.parseInt(br.readLine());
			ans = new int[n];
			String[] str = br.readLine().split(" ");
			
			for(int i=0; i<n; i++) {
				int a = Integer.parseInt(str[i]);
//				System.out.println("a="+a);
				if(stack.isEmpty()) {					
					stack.add(new Pair(a, i+1));
					ans[i] = 0;
				}
				else {
					while(true) {
						if(stack.isEmpty()) {
							stack.add(new Pair(a, i+1));
							ans[i] = 0;
							break;
						}
						if(a < stack.peek().x) {
							ans[i] = stack.peek().y;
							stack.add(new Pair(a, i+1));
							break;
						} else {
							stack.pop();
						}
					}
				}
				
//				System.out.print("stack : ");
//				for(Pair s: stack) {
//					System.out.print("("+s.x+", "+s.y+")");
//				}
//				
//				System.out.print("\nans[] : ");
//				for(int s: ans) {
//					System.out.print(s+" ");
//				}
//				System.out.println("\n");
			}	
			
			for(int i=0; i<n; i++) {
				sb.append(ans[i]).append(" ");
			}
			System.out.println(sb);
		} catch(Exception e) {}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
