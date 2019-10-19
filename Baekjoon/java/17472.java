import java.util.*;
import java.io.*;

/**완전탐색, bfs, MST(Kruskal)*/
public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m;
	int[][] area;
	// bfs	
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int cnt_island = 0;
	int[][] vis;
	
	// kruskal
	PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2)->Integer.valueOf(o1.len).compareTo(o2.len));
	int[] root;
	int ans = 0;
	
	private class Pair {
		int x, y, len;
		// (행, 열) 좌표
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		// 섬A에서 섬B로 가는 다리의 길이
		public Pair(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}
	
	void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		area = new int[n][m];
		vis = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
	}
	
	/**섬을 찾아서 번호를 붙이기 위한 함수*/
	void bfs(int x, int y, int cnt) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		vis[x][y] = cnt;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(vis[nx][ny]==0 && area[nx][ny]==1) {
						vis[nx][ny] = cnt;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
	void make_bridge(int x, int y, int from) {
		int len = -1;
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx>=0 && nx<n && ny>=0 && ny<m) {
				if(area[nx][ny]==0) {
					// 그 방향으로 쭉 가서 vis가 0이 아닌 어떤 수가 나오면 그 길이 return
					// 범위를 벗어나버리면 -1 return
					len = 1;
					while(true) {
						nx += dx[k];
						ny += dy[k];
						if(nx<0 || nx>=n || ny<0 || ny>=m) break;
						if(area[nx][ny]==0) {
							len += 1;
						} else {
							if(len >= 2) {
								pq.add(new Pair(from, vis[nx][ny], len));
							}
							break;
						}
					}
				}
			}
		}
	}
		
	int find(int a) {
		if(root[a] == -1) {
			return a;
		}
		return root[a] = find(root[a]);
	}
	
	boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			root[pa] = pb;
			return true;
		}
		return false;
	}
	
	void kruskal() {
		root = new int[cnt_island+1];
		Arrays.fill(root, -1);
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(union(p.x, p.y)) {
				ans += p.len;
			}
		}	
	}
	
	void solve() throws IOException {
		input();
		
		cnt_island = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(vis[i][j]==0 && area[i][j]==1) {
					bfs(i, j, cnt_island++);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(area[i][j] == 1) {
					make_bridge(i, j, vis[i][j]);
				}
			}
		}
				
		kruskal();
		
		int cnt_root = 0;
		for(int i=1; i<cnt_island; i++) {
			if(root[i]==-1) {
				cnt_root++;
			}
			if(cnt_root > 1) break;
		}
		
		if(ans==0 || cnt_root!=1) System.out.println(-1);
		else System.out.println(ans);	
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
