import java.io.*;
import java.util.*;

public class Solution {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	void solve() throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[][] vis = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(vis[i][j]==0) {						
						int ni = i+2;
						int nj = j+2;
						if(ni<n) vis[ni][j] = -1;
						if(nj<m) vis[i][nj] = -1;
					}
				}
			}
			
			int ans = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(vis[i][j]==0)
						ans++;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
