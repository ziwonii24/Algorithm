import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m;
	int[][] area;
	Pair[] virus = new Pair[10];
	int cnt_virus = 0;
	// dfs
	List<Integer> stack = new ArrayList<>();
	boolean[] check;
	
	// bfs	
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int[][] vis;
	Queue<Pair> q = new LinkedList<>();
	
	int ans = Integer.MAX_VALUE;
	
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
		area = new int[n][n];
		vis = new int[n][n];
		int idx = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken()); 
				if(area[i][j]==2) {
					virus[idx++] = new Pair(i, j);
					cnt_virus++;
				}
			}
		}
		check = new boolean[cnt_virus];
	}
	
	void bfs() {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					// 방문안한 빈칸
					if((vis[nx][ny] == -1 || vis[x][y]+1 < vis[nx][ny]) && area[nx][ny] != 1) {						
						vis[nx][ny] = vis[x][y] + 1;
						q.add(new Pair(nx, ny));						
					}
				}
			}
		}
	}
	
	int counting() {
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 벽이 아닌데 방문을 안한 경우
				if(area[i][j] != 1 && vis[i][j] == -1) {
					return -1;
				} 
				// 벽이 아니고 방문 한 경우
				else if(area[i][j] == 0 && vis[i][j] != -1) {
					max = max<vis[i][j]?vis[i][j]:max;
				}
			}
		}
		return max;
	}

	void dfs(int t) {
		if(stack.size()==m) {			
			// 고른 바이러스 활성 바이러스로 만들고 퍼뜨리기
			q.clear();
			for(int i=0; i<n; i++) {
				Arrays.fill(vis[i], -1);
			}
			
			for(int idx: stack) {
				int x = virus[idx].x;
				int y = virus[idx].y;
				vis[x][y] = 0;
				q.add(new Pair(x, y));
			}
						
			bfs();
			
			int res = counting();
			if(res != -1) {
				ans = res<ans?res:ans;
			}
			
			return;
		}
		
		for(int i=t; i<cnt_virus; i++) {
			if(!check[i]) {
				check[i] = true;
				stack.add(i);
				dfs(i+1);
				check[i] = false;
				stack.remove(stack.size()-1);
			}
		}
	}
	
	void solve() throws IOException {
		input();	
		dfs(0);
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
