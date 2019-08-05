import java.io.*;
import java.util.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n, m, r, c, d, cnt=0;
	int[][] map, vis;
	
	void input() {
		try {
			String[] nm = br.readLine().split(" ");
			String[] rcd = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			r = Integer.parseInt(rcd[0]);
			c = Integer.parseInt(rcd[1]);
			d = Integer.parseInt(rcd[2]);	// 0123:북동남서						
			map = new int[n][m];
			vis = new int[n][m];
			for(int i=0; i<n; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}		
		} catch(IOException e) {}		
	}
	
	void print(int[][] arr) {
		System.out.println("==========");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	void solve() {		
		input();
		
		while(true) {
			boolean flag = false;
			// 1. 현재 위치 청소
			vis[r][c] = 1;
			
			// 2. 현재 위치에서 현재 방향기준으로 왼쪽부터 차례로 탐색
			for(int i=0; i<4; i++) {
				d--;
				if(d<0) d=3;
				
				int nr=r, nc=c;
				if(d==0) {
					nr--;
				} else if(d==1) {
					nc++;
				} else if(d==2) {
					nr++;
				} else if(d==3) {
					nc--;
				}
				
				// a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재하면, 그 방향으로 회전, 한칸전진 -> 1번
				if(vis[nr][nc]==0 && map[nr][nc]==0) {
					flag = true;
					r=nr; c=nc;
					break;
				}
				// b. 왼쪽 방향에 청소할 공간이 없으면, 그 방향으로 회전 -> 2번
			}	
			
			if(!flag) {
				// c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우, 방향유지한채로 한칸후진 -> 2번
				int nr=r, nc=c;
				if(d==0) {
					nr++;
				} else if(d==1) {
					nc--;
				} else if(d==2) {
					nr--;
				} else if(d==3) {
					nc++;
				}
				// d.
				if(map[nr][nc]==1) {
					break;
				} else {
					r=nr; c=nc;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(vis[i][j]!=0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}		
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
