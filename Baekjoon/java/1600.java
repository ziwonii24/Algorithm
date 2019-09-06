import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int N, M, K;
	int[][] arr;
	int[][][] vis;
	final int[] dx = {0,0,1,-1, -1,-2,-2,-1,1,2,2,1};
	final int[] dy = {1,-1,0,0, -2,-1,1,2,-2,-1,1,2};
	
	void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0,0));
		vis[0][0][0] = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			int c = p.c;
			for(int k=0; k<12; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				int nc = c;
				if(4<=k && k<12) nc=c+1;
				if(K < nc) continue;
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(arr[nx][ny]==1) continue;
					if(vis[nx][ny][nc]==-1) {
						q.add(new Pair(nx, ny, nc));
						vis[nx][ny][nc] = vis[x][y][c]+1;
					} 
				}
			}
		}
	}
	
	void solve() throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		vis = new int[N][M][K+1];		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				for(int k=0; k<K+1; k++) {
					vis[i][j][k] = -1;
				}
			}
		}
		bfs();
		int ans = Integer.MAX_VALUE;
		boolean flag = false;
		for(int k=0; k<=K; k++) {
			int tmp = vis[N-1][M-1][k];
			if(tmp!=-1) {
				flag = true;
				ans = tmp<ans?tmp:ans;
			}
		}
		
		if(!flag) ans=-1;
		sb.append(ans);
		System.out.println(sb);
	}
	
	class Pair {
		int x, y, c;
		public Pair(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
