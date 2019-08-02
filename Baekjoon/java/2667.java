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
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int n;
	int[][] map, vis;
	
	void input() {
		try {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			vis = new int[n][n];
			for(int i=0; i<n; i++) {
				String row = br.readLine();
				for(int j=0; j<n; j++) {
					map[i][j] = row.charAt(j)-'0';
				}
			}
		} catch(IOException e) {}
	}
	
	void bfs(int x, int y, int cnt) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			vis[x][y] = cnt;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(map[nx][ny]==1 && vis[nx][ny]==0) {
						q.add(new Pair(nx, ny));
						vis[nx][ny] = cnt;
					}
				}
			}
		}
	}
	
	void solve() {
		input();
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && vis[i][j]==0) {
					bfs(i, j, ++cnt);
				}
			}
		}
		System.out.println(cnt);
		
		int[] group = new int[cnt+1];		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(vis[i][j]!=0) {
					group[vis[i][j]]+=1;
				}
			}
		}
		Arrays.sort(group);
		for(int i=1; i<group.length; i++) {
			System.out.println(group[i]);
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}	
}
