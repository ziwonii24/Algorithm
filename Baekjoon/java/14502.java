import java.io.*;
import java.util.*;

public class Main {
	
	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0};
	int n, m;
	int[][] map;
	int[][] wall;
	
	void print(int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==-1) System.out.print("- ");
				else System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		try {
			String[] nm = br.readLine().split(" ");			
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			map = new int[n][m];
			wall = new int[n][m];
			for(int i=0; i<n; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(row[j]);
					if(map[i][j]==1) wall[i][j] = 1;
					else if(map[i][j]==2) wall[i][j] = 2;
				}
			}
		} catch(IOException e) {}		
	}
	
	void bfs() {
		print(wall);
		System.out.println("bfs를 해보자!");
	}
	
	void dfs(int cnt) {
		if(cnt==3) {			
			bfs();
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(wall[i][j]==0) {
					wall[i][j] = 1;
					dfs(cnt+1);
					wall[i][j] = 0;
				}
			}
		}
	}
	
	void solve() {
		input();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {
					wall[i][j] = 1;
					dfs(1);		
					
				}
			}
		}
		
		
	} // end of solve
	
	public static void main(String[] args) {
		new Main().solve();
	} // end of main
} // end of class
