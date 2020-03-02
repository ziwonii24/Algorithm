import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	int n, m;
	int[][] map;
	int[][] group;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int[][] graph;
	int ans = 0;
	
	void grouping(int x, int y, int gnum) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		group[x][y] = gnum;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(map[nx][ny]==1 && group[nx][ny]==0) {
					q.add(new Pair(nx, ny));
					group[nx][ny] = gnum;
				}
			}
		}
	}
	
	int min(int a, int b) {
		if(a == -1) return b;
		else return a < b ? a : b;
	}
	
	void connecting(int x, int y, int gnum) {
		for(int k=0; k<4; k++) {	// 상하좌우
			int len = 0;
			int meet = 0;
			while(true) {
				len++;
				int nx = x + dx[k]*len;
				int ny = y + dy[k]*len;
				if(nx<0 || nx>=n || ny<0 || ny>=m) break;
				if(group[nx][ny] == gnum) break;
				if(group[nx][ny] != 0) {
					meet = group[nx][ny];
					break;
				}
			}
			if(len-1 == 1) continue;
			if(meet != 0) {
				// graph 최소 갱신
				graph[gnum][meet] = min(graph[gnum][meet], len-1);
			}
		}
	}
	
	void prim(int gnum) {
		boolean[] vis = new boolean[gnum];
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.valueOf(o1.y).compareTo(o2.y));
		
		vis[1] = true;
		for(int i=1; i<gnum; i++) {
			if(graph[1][i] < 2) continue;
			pq.add(new Pair(i, graph[1][i]));
		}
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int dest = p.x;
			int cost = p.y;
			
			if(!vis[dest]) {
				vis[dest] = true;
				ans += cost;
				cnt += 1;
				if(cnt == gnum-2) {
					break;
				}
				for(int i=1; i<gnum; i++) {
					if(graph[dest][i] < 2) continue;
					pq.add(new Pair(i, graph[dest][i]));
				}
			}
		}
		
		if(cnt != gnum-2) {
			ans = -1;
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		group = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 섬 그룹화
		// 2. 섬과 섬 사이 최소 다리길이 구하기
		// 3. 모든 섬이 연결되어있는지하면서 총 다리길이 최소 구하기
		
		int gnum = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && group[i][j]==0) {
					grouping(i, j, gnum++);
				}
			}
		}
		
		graph = new int[gnum][gnum];
		for(int i=0; i<gnum; i++) {
			Arrays.fill(graph[i], -1);
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(group[i][j] != 0) {
					connecting(i, j, group[i][j]);
				}
			}
		}
				
		prim(gnum);
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
