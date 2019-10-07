import java.io.*;
import java.util.*;

public class Solution {	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	void solve() throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[2]);
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			for(int i=1; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				
				int ax = Math.abs(x2 - x1);
				int ay = Math.abs(y2 - y1);
				
				if((x2-x1)*(y2-y1)>0) {
					if(ax > ay) {
						ans += ay+(ax-ay);
					} else {
						ans += ax+(ay-ax);
					}
				} else {
					ans += (ax + ay);
				}
				
				x1 = x2;
				y1 = y2;
			}
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
