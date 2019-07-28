import java.io.*;
import java.util.*;

public class Main {
	
	int n, m;
	ArrayList<Integer> arr = new ArrayList<Integer>();
	boolean[] vis;
	
	void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		try {
			String[] nm = br.readLine().split(" ");			
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			vis = new boolean[n];			
		} catch(IOException e) {}		
	}
	
	void dfs() {
		if(arr.size()==m) {			
			for(int i=0; i<m; i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!vis[i-1]) {
				vis[i-1] = true;
				arr.add(i);
				dfs();
				vis[i-1] = false;
				arr.remove(arr.size()-1);
			}
		}
	}
	
	void solve() {
		init();
		dfs();
	} // end of solve
	
	public static void main(String[] args) {
		new Main().solve();
	} // end of main
} // end of class
