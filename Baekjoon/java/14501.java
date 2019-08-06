import java.io.*;
import java.util.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n, ans=0;
	int[] t, p;
	boolean[] check;
	Stack<Integer> stack = new Stack<>();
	
	void input() {
		try {
			n = Integer.parseInt(br.readLine());
			t = new int[n+1];
			p = new int[n+1];
			check = new boolean[n+1];
			for(int i=1; i<=n; i++) {
				String[] tp = br.readLine().split(" ");
				t[i] = Integer.parseInt(tp[0]);
				p[i] = Integer.parseInt(tp[1]);
			}
			
		} catch(IOException e) {}		
	}
	
//	void dfs(int x) {
////		System.out.println("x="+x);
//		if(n < x || n < x+t[x]-1) {			
//			int sum = 0;
//			for(int s: stack) {
//				System.out.print(s+" ");
//				sum += p[s];
//			}
//			System.out.println();			
//			
//			if(ans < sum)
//				ans = sum;
//			return;
//		}
//		
//		for(int i=x; i<=n; i++) {
//			if(!check[i] && i+t[i]-1<=n) {
//				check[i] = true;
//				stack.add(i);
//				dfs(i+t[i]);
//				check[i] = false;
//				stack.pop();
//			}
//		}
//	}
	
	void dfs(int x) {
		int sum = 0;
		for(int item: stack) {
//			System.out.print(item+" ");
			sum+=p[item];
		}
//		System.out.println();
		if(ans < sum) {
			ans = sum;
		}
		
		for(int i=x; i<=n; i++) {
			if(!check[i] && i+t[i]-1<=n) {
				check[i] = true;
				stack.add(i);
				dfs(i+t[i]);
				check[i] = false;
				stack.pop();
			}
		}
	}
	
	
	void solve() {		
		input();
		
//		for(int i=1; i<=n; i++)
//			dfs(i);
		dfs(1);
		
		System.out.println(ans);
	}		
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
