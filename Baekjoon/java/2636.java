import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	int[][] map, vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	
	void bfs() {
		for(int i=0; i<n; i++) {
			Arrays.fill(vis[i], 0);
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		vis[0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(vis[nx][ny]==0 && map[nx][ny]==0) {
						vis[nx][ny] = 1;
						q.add(new Pair(nx, ny));
					} else if(vis[nx][ny]==0 && map[nx][ny]==1) {
						vis[nx][ny] = 2;
					}
				}
			}
		}
	}
	
	int count() {
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1) {
					sum += 1;
				}
			}
		}
		return sum;
	}
	
	void remove() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(vis[i][j]==2) {
					map[i][j] = 0;
				}
			}
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		vis = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int time = 0;
		while(true) {
			int tmp = count();
			if(tmp==0) {
				break;
			}
			time += 1;
			cnt = tmp;
			bfs();		
			remove();
		}
		sb.append(time).append('\n').append(cnt);
		System.out.println(sb);
	}
	
	void print(int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==-1) System.out.print("- ");
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
