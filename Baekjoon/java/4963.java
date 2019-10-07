import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	int[][] map, vis;
	final int[] dx = {0,0,1,-1,1,1,-1,-1};
	final int[] dy = {1,-1,0,0,1,-1,1,-1};
	
	private class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		vis[x][y] = 1;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {				
					if(vis[nx][ny]==0 && map[nx][ny]==1) {
						vis[nx][ny] = 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
	void solve() throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0) {
				break;
			}
			
			map = new int[n][m];
			vis = new int[n][m];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			int ans = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(vis[i][j]==0 && map[i][j]==1) {
						ans += 1;
						bfs(i, j);						
					}
				}
			}
			sb.append(ans).append('\n');
		}
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
