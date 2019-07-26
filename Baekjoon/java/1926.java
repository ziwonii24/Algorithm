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
			String[] row = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==1 && vis[i][j]==0) {	// 아직 방문안한 1이면
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(i, j));
					vis[i][j] = ++cnt;
					
					while(!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						
						for(int k=0; k<4; k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							
							if(nx>=0 && nx<n && ny>=0 && ny<m) {
								if(arr[nx][ny]==1 && vis[nx][ny]==0) {
									q.add(new Pair(nx, ny));
									vis[nx][ny] = cnt;
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
		int[] area = new int[cnt+1];
		if(cnt!=0) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					area[vis[i][j]]++;
				}
			}
		}
		
		int max_area = 0;
		for(int i=1; i<cnt+1; i++) {
			if(max_area < area[i]) {
				max_area = area[i];
			}
		}
		
//		int area = 0;
//		int max_area = 0;
//		
//		while(cnt>0) {
////			System.out.println("cnt="+cnt);
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					if(vis[i][j]==cnt) {
//						area+=1;
//					}
//				}
//			}
////			System.out.println("area="+area);
//			if(max_area<area) {
//				max_area = area;
//			}
//			area=0; 
//			cnt-=1;
//		}
		
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(vis[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(max_area);
	}
}
