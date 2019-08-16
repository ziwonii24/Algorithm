import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int n;
	char[][] arr;
	boolean[][] vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	
	void init() {
		try {
			n = Integer.parseInt(br.readLine());
			arr = new char[n][n];
			vis = new boolean[n][n];
			for(int i=0; i<n; i++) {
				String row = br.readLine();
				for(int j=0; j<n; j++) {
					arr[i][j] = row.charAt(j);
				}
			}
		} catch(IOException e) {}
	}
	
	void bfs(int x, int y, char color) {
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
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(!vis[nx][ny] && arr[nx][ny]==color) {
						vis[nx][ny]=true;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
	void solve() {
		init();
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!vis[i][j]) {
					bfs(i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(" ");
		cnt = 0;
		for(int i=0; i<n; i++)
			Arrays.fill(vis[i], false);		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]=='R')
					arr[i][j]='G';
			}
		}		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!vis[i][j]) {
					bfs(i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
