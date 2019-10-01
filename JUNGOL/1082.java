import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	char[][] map;
	int[][] fire, js;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	Queue<Pair> fq = new LinkedList<>();
	Queue<Pair> jq = new LinkedList<>();
	
	void fire_bfs() {
		while(!fq.isEmpty()) {
			Pair p = fq.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(fire[nx][ny]==-1 && map[nx][ny]=='.') {
						fq.add(new Pair(nx, ny));
						fire[nx][ny] = fire[x][y] + 1;
					}
				}
			}
		}
	}
	
	void js_bfs() {
		while(!jq.isEmpty()) {
			Pair p = jq.poll();
			int x = p.x;
			int y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(js[nx][ny]==-1 && (map[nx][ny]=='.' || map[nx][ny]=='D')) {
						if(js[x][y]+1 < fire[nx][ny] || fire[nx][ny]==-1) {
							jq.add(new Pair(nx, ny));
							js[nx][ny] = js[x][y] + 1;
						}
					}
				}
			}
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		fire = new int[n][m];
		js = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(fire[i], -1);
		}
		for(int i=0; i<n; i++) {
			Arrays.fill(js[i], -1);
		}
		Pair goal = null;
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='*') {
					fq.add(new Pair(i, j));
					fire[i][j] = 0;
				} else if(map[i][j]=='S') {
					map[i][j] = '.';
					jq.add(new Pair(i, j));
					js[i][j] = 0;
				} else if(map[i][j]=='D') {
					goal = new Pair(i, j);
				}
			}
		}
		fire_bfs();
//		print(fire);
		js_bfs();
//		print(js);
		if(js[goal.x][goal.y]==-1) {			
			System.out.println("impossible");
		} else {
			System.out.println(js[goal.x][goal.y]);			
		}
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
