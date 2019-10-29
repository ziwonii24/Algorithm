import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	int n;
	int[][] arr;
	boolean[] check;
	int ans = Integer.MAX_VALUE;
	
	void dfs(int idx, int cnt, int sum) {	
		if(ans < sum) return;
		if(cnt == n && arr[idx][0] != 0) {
			ans = Math.min(ans, sum+arr[idx][0]);
			return;
		}
		
		for(int i=1; i<n; i++) {
			if(!check[i] && arr[idx][i] != 0) {
				check[i] = true;
				dfs(i, cnt+1, sum+arr[idx][i]);
				check[i] = false;
			}
		}
	}
		
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check = new boolean[n];
		dfs(0, 1, 0);
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
