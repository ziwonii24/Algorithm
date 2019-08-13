import java.util.*;
import java.io.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	String n;
	int m;
	int len;
	int ans = 0;
	boolean[][] vis;
	
	String swap(String str, int i, int j) {
		StringBuilder tmp = new StringBuilder();
		for(int k=0; k<len; k++) {
			if(k==i) tmp.append(str.charAt(j));
			else if(k==j) tmp.append(str.charAt(i));
			else tmp.append(str.charAt(k));
		}
		return tmp.toString();
	}
	
	void dfs(String str, int cnt) {
		int num = Integer.parseInt(str);
		if(vis[num][cnt]) return;
		vis[num][cnt] = true;
		if(cnt==0) {
			if(ans < num) ans = num;
			return;
		}
		
		for(int i=0; i<len-1; i++) {
			for(int j=i+1; j<len; j++) {				
				dfs(swap(str, i, j), cnt-1);
			}
		}
	}
	
	void solve() {
		try {
			int testcase = Integer.parseInt(br.readLine());
			for(int tc=1; tc<=testcase; tc++) {
				st = new StringTokenizer(br.readLine(), " ");
				n = st.nextToken();
				m = Integer.parseInt(st.nextToken());
				len = n.length();
				ans = 0;
				vis = new boolean[1000000][m+1];
				dfs(n, m);
				sb.append("#").append(tc).append(" ").append(ans).append("\n");
			}
			System.out.println(sb);
			
		} catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
