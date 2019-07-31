import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int n, m, max_sum = 0;
	int[][] map, wall, vis;
	Queue<Pair> q = new LinkedList<Pair>();
	
	void bfs() {
		for (int k = 0; k < map.length; ++k) {
			vis[k] = wall[k].clone();
		}
//		System.out.println("----");
		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(vis[i]));
			for(int j=0; j<m; j++) {
				if(vis[i][j]==2) {
					q.add(new Pair(i, j));
				}
			}
		}
//		System.out.println("----");
//		System.out.println("q.size = "+q.size());
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(vis[nx][ny]==0) {
						vis[nx][ny] = 2;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
//		System.out.println("q.empty= "+q.isEmpty());
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(vis[i][j] == 0) {
					sum += 1;
				}
			}
		}
//		System.out.println("sum = "+sum);
		
		if(max_sum < sum) {
			max_sum = sum;
		}
	}
	
	void dfs(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(wall[i][j]==0) {
					wall[i][j] = 1;
					dfs(cnt+1);
					wall[i][j] = 0;
				}
			}
		}
	}
	
	void solve() {
		try {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			map = new int[n][m];
			wall = new int[n][m];
			vis = new int[n][m];
			for(int i=0; i<n; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==0) {
//						wall = map.clone();
						for (int k = 0; k < map.length; ++k) {
							wall[k] = map[k].clone();
						}
						wall[i][j] = 1;
						dfs(1);
						wall[i][j] = 0;
					}
				}
			}
			
			System.out.println(max_sum);
			
		} catch(Exception e) {}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
