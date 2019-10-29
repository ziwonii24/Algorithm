import java.io.*;
import java.util.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	char[][] arr;
	int[] stk = new int[3];
	int ans = Integer.MAX_VALUE;
	
	int painting() {
		int cnt = 0;
		// white
		for(int i=0; i<stk[0]; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] != 'W') {
					cnt++;
				}
			}
		}
		
		// blue
		for(int i=stk[0]; i<stk[0]+stk[1]; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] != 'B') {
					cnt++;
				}
			}
		}
		
		// red
		for(int i=stk[0]+stk[1]; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] != 'R') {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	void dfs(int x, int idx) {
		if(idx == 3) {
			if(stk[0]+stk[1]+stk[2] == n) {
				int res = painting();
				if(res < ans) {
					ans = res;
				}
			}
			return;
		}
		
		for(int i=1; i<=n-2; i++) {
			stk[idx] = i;
			dfs(i, idx+1);
		}
	}

	void solve() throws  IOException {		
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new char[n][m];
			for(int i=0; i<n; i++) {
				String line = br.readLine();
				for(int j=0; j<m; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			stk[0] = 1; stk[1] = 0; stk[2] = 0;
			ans = Integer.MAX_VALUE;
			dfs(1, 0);					
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
