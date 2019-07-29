import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	
	StringBuilder sb = new StringBuilder();
	int n, m;
	ArrayList<Integer> arr = new ArrayList<>();
	boolean[] vis;
	
	private void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			vis = new boolean[n];
		} catch(IOException e) {}
	}
	
	private void dfs() {
		if(arr.size()==m) {
			for(int i=0; i<m; i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
//			if(!vis[i]) {
				vis[i] = true;
				arr.add(i+1);
				dfs();
				vis[i] = false;
				arr.remove(arr.size()-1);
//			}
		}
	}
	
	private void solve() {
		init();
		dfs();
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
