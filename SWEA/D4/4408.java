import java.util.*;
import java.io.*;

class Node {
	int x, y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	void solve() throws IOException {
		
		int testcase = Integer.parseInt(br.readLine());
		int n;
		int cs, ce;	// 복도번호 시작과 끝
		for(int tc=1; tc<=testcase; tc++) {
			int[] vis = new int[201];
			n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				cs = (Integer.parseInt(st.nextToken())+1)/2;
				ce = (Integer.parseInt(st.nextToken())+1)/2;				
				if(ce < cs) {
					int tmp = ce;
					ce = cs;
					cs = tmp;
				}
				for(int k=cs; k<=ce; k++) {
					vis[k] += 1;
				}				
			}	
			int time = 0;
			for(int k=1; k<vis.length; k++) {
				if(time < vis[k]) {
					time = vis[k];
				}
			}
			sb.append('#').append(tc).append(' ').append(time).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
