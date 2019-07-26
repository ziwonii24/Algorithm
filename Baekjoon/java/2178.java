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
	
	public static final int dx[] = {0,0,1,-1};
	public static final int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int[][] arr = new int[n][m];
		int[][] vis = new int[n][m];
		for(int i=0; i<n; i++) {
			String row = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = row.charAt(j)-'0';
			}
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0));
		vis[0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(vis[nx][ny]==0 && arr[nx][ny]==1) {
						vis[nx][ny]=vis[x][y]+1;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
		
		System.out.println(vis[n-1][m-1]);
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(vis[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
}
