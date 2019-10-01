import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	char[][] map;
	boolean[] abc = new boolean[26];
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int ans = 0;
	
	void dfs(int x, int y, int cnt) {
		if(ans < cnt) {
			ans = cnt;
		}
		abc[map[x][y]-'A'] = true;
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx>=0 && nx<n && ny>=0 && ny<m) {
				if(!abc[map[nx][ny]-'A']) {
					dfs(nx, ny, cnt+1);					
				}
			}
		}
		abc[map[x][y]-'A'] = false;
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
