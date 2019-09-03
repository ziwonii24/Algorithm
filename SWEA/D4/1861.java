import java.util.*;
import java.io.*;

public class Solution {
	
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[][] arr;
	int[][] vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int room_num = 0;
	int room_cnt = 0;
	
	void bfs(int x, int y, int num) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		for(int i=0; i<n; i++)
			Arrays.fill(vis[i], 0);
		vis[x][y] = num;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(vis[nx][ny]==0 && arr[x][y]+1==arr[nx][ny]) {
						vis[nx][ny] = num;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
	void counting(int num) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(vis[i][j]==num) {
					sum += 1;
				}
			}
		}
		if(room_cnt < sum) {			
			room_cnt = sum;
			room_num = num;
		} else if(room_cnt == sum && num < room_num) {
			room_num = num;
		}
	}
	
	void init() {
		arr = new int[n][n];
		vis = new int[n][n];
		room_num = n*n+1;
		room_cnt = 0;
	}
	
	void solve() throws IOException {	
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			n = Integer.parseInt(br.readLine());
			init();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					bfs(i, j, arr[i][j]);
					counting(arr[i][j]);
				}
			}
						
			sb.append('#').append(tc).append(' ').append(room_num).append(' ').append(room_cnt).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
