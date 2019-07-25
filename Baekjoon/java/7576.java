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
	
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[1]);	
		int m = Integer.parseInt(nm[0]);
		int[][] arr = new int[n][m];
		int[][] vis = new int[n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				vis[i][j] = -1;
				if(arr[i][j]==1) {
					q.add(new Pair(i, j));
					vis[i][j] = 0;
				}
			}
		}
		
		// bfs
		while(!q.isEmpty()) {
			Pair p = q.remove();	// pop + return
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(vis[nx][ny]==-1 && arr[nx][ny]!=-1) {
						q.add(new Pair(nx, ny));
						vis[nx][ny] = vis[x][y] + 1;
					}
				}
			}
		}
		
		boolean flag = false;
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(ans < vis[i][j]) {
					ans = vis[i][j];
				}			
				if(arr[i][j]==0 && vis[i][j]==-1) {	// 안 익은 토마토에 방문한적 없을 경우
					flag = true;
				}
			}
		}
		
		if(flag) {
			System.out.println(-1);
		} else {
		System.out.println(ans);
		}
		
	
	} // end of main
} // end of class






