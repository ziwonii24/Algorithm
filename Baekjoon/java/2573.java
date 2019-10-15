import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m;
	int[][] area;
	boolean[][] vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	
	private class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		area = new int[n][m];
		vis = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
	}
	
	boolean all_melt() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(area[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		vis[x][y] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(!vis[nx][ny] && area[nx][ny]!=0) {
						q.add(new Pair(nx, ny));
						vis[nx][ny] = true;
					}
				}
			}
		}
	}
	
	boolean cnt_twomore() {
		for(int i=0; i<n; i++) {
			Arrays.fill(vis[i], false);
		}
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!vis[i][j] && area[i][j]!=0) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		if(cnt >= 2) {
			return true;
		}		
		return false;
	}
	
	void melting() {
		int[][] tmp = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(area[i][j] == 0) continue;
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx>=0 && nx<n && ny>=0 && ny<m) {
						if(area[nx][ny]==0) {
							tmp[i][j]++;
						}
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int diff = area[i][j] - tmp[i][j];
				if(diff < 0) {
					area[i][j] = 0;
				} else {
					area[i][j] = diff;
				}				
			}
		}	
	}
		
	void solve() throws IOException {
		input();
		int year = 0;
		while(true) {
			// 1. 다 녹앗다 -> 0
			if(all_melt()) {
				System.out.println(0);
				break;
			}
			// 2. 두덩어리이상인가 -> year
			if(cnt_twomore()) {
				System.out.println(year);
				break;
			}	
			year++;
			// 3. 녹이기
			melting();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
