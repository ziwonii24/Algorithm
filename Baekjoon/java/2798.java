import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	int n, m;
	int[] arr;
	boolean[] vis;
	int[] card = new int[3];
	int ans = 0;
	
	void comb(int idx, int x) {
				
		if(idx == 3) {
			int sum = card[0] + card[1] + card[2];
			if(sum <= m) {
				ans = ans < sum ? sum : ans;
			}
			return;
		}
		
		for(int i=x; i<n; i++) {
			if(!vis[i] && arr[i]<=m) {
				vis[i] = true;
				card[idx] = arr[i];
				comb(idx+1, x++);
				vis[i] = false;
			}
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		vis = new boolean[n];
		st = new StringTokenizer(br.readLine());		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
