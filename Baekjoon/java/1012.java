import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	StringBuilder sb = new StringBuilder();
	int testcase, n, m, k;
	int[][] map, vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	
	void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			vis[x][y] = 1;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]==1 && vis[nx][ny]==0) {
						vis[nx][ny] = 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
	void solve() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testcase = Integer.parseInt(br.readLine());
			for(int tc=0; tc<testcase; tc++) {
				String[] nmk = br.readLine().split(" ");
				m = Integer.parseInt(nmk[1]);
				n = Integer.parseInt(nmk[0]);
				k = Integer.parseInt(nmk[2]);				
				map = new int[n][m];
				vis = new int[n][m];
				
				for(int i=0; i<k; i++) {
					String[] xy = br.readLine().split(" ");
					int x = Integer.parseInt(xy[0]);
					int y = Integer.parseInt(xy[1]);
					map[x][y] = 1;
				}
				
//				print(map);
				
				int cnt = 0;
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						if(map[i][j]==1 && vis[i][j]==0) {
							cnt+=1;
							bfs(i, j);
						}
					}
				}
				sb.append(cnt+"\n");
			}
			System.out.println(sb);
		} catch(IOException e) {}		
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
	
	void print(int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
