import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int N, M, K;
	boolean[][] area, vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};	
    List<Integer> list = new ArrayList<>();
	
	void init() {
		try {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			area = new boolean[N][M];
			vis = new boolean[N][M];
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int ly = Integer.parseInt(st.nextToken());
				int lx = Integer.parseInt(st.nextToken());
				int ry = Integer.parseInt(st.nextToken());
				int rx = Integer.parseInt(st.nextToken());
				for(int i=lx; i<rx; i++) {
					for(int j=ly; j<ry; j++) {
						area[i][j] = true;
					}
				}
			}
		} catch(IOException e) {}
	}
	
	int bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		vis[x][y] = true;
		int sum = 1;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!vis[nx][ny] && !area[nx][ny]) {
						sum += 1;
						q.add(new Pair(nx, ny));
						vis[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}
	
	void solve() {
		init();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!vis[i][j] && !area[i][j]) {
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for(int item: list) {
			sb.append(item).append(' ');
		}
		System.out.println(sb);
	}
	
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    
	public static void main(String[] args) {
		new Main().solve();
	}
}
