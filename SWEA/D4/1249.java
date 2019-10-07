import java.io.*;
import java.util.*;

public class Solution {	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[][] map, vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	
	void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		vis[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(vis[nx][ny]==-1 || vis[x][y]+map[nx][ny] < vis[nx][ny]) {
						vis[nx][ny] = vis[x][y] + map[nx][ny];
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
	void solve() throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			vis = new int[n][n];
			for(int i=0; i<n; i++) {
				String line = br.readLine();				
				for(int j=0; j<n; j++) {
					map[i][j] = line.charAt(j)-'0';
					vis[i][j] = -1;
				}
			}
			bfs(0,0);
			int ans = vis[n-1][n-1];
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	private class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
