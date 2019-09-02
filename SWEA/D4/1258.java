import java.util.*;
import java.io.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[][] arr, vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	Pair start, end;
	
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
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(vis[nx][ny]==0 && arr[nx][ny]!=0) {
						vis[nx][ny] = 1;						
						q.add(new Pair(nx, ny));
						end = new Pair(nx, ny);
					}
				}
			}			
		}
	}
	
	void solve() throws IOException {	
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			vis = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			List<Pair> list = new ArrayList<>();
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(vis[i][j]==0 && arr[i][j]!=0) {						
						cnt++;
						start = new Pair(i, j);
						bfs(i, j);	
						int row = end.x - start.x + 1;
						int col = end.y - start.y + 1;
						int area = row * col;
						list.add(new Pair(row, col, area));
					}
				}
			}
			list.sort(new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if(o1.area == o2.area) {
						return Integer.valueOf(o1.x).compareTo(o2.x);
					}
					return Integer.valueOf(o1.area).compareTo(o2.area);
				}				
			});
            
			sb.append('#').append(tc).append(' ').append(cnt);
			for(Pair item : list) {
				sb.append(' ').append(item.x).append(' ').append(item.y);
			}
			sb.append('\n');			
		}
		System.out.print(sb);
	}
	
	class Pair {
		int x, y, area;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pair(int x, int y, int area) {
			this.x = x;
			this.y = y;
			this.area = area;
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
