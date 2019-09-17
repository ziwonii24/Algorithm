import java.util.*;
import java.io.*;

public class Solution {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int INF = 1001;
		
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[][] net = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(net[i], INF);
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp != 0) net[i][j] = tmp;
					if(i==j) net[i][j] = 0;
				}
			}
			
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						net[i][j] = Math.min(net[i][k] + net[k][j], net[i][j]);
					}
				}
			}

			int ans = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				int sum = 0;
				for(int j=0; j<n; j++) {
					if(net[i][j]!=INF) {
						sum += net[i][j];
					}
				}
				ans = Math.min(ans, sum);
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
}
