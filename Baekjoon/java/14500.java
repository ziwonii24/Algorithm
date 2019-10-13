import java.io.*;
import java.util.*;

/**그냥 구현, 완탐, 노가다*/
public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m;
	int[][] arr;
	int ans = 0;
	
	void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	void solve() throws IOException {
		input();
		
		// ㅡ
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int j1 = j+1;
				int j2 = j+2;
				int j3 = j+3;
				if(j1>=m || j2>=m || j3>=m) continue;
				int sum = arr[i][j]+arr[i][j1]+arr[i][j2]+arr[i][j3];
				if(ans < sum) {
					ans = sum;
				}				
			}
		}
		
		// ㅣ
		for(int i=0; i<n; i++) {
			int i1 = i+1;
			int i2 = i+2;
			int i3 = i+3;
			if(i1>=n || i2>=n || i3>=n) continue;
			for(int j=0; j<m; j++) {
				int sum = arr[i][j]+arr[i1][j]+arr[i2][j]+arr[i3][j];
				if(ans < sum) {
					ans = sum;
				}
			}
		}
		
		// ㅁ
		for(int i=0; i<n; i++) {
			int i1 = i+1;
			if(i1>=n) continue;
			for(int j=0; j<m; j++) {
				int j1 = j+1;
				if(j1>=m) continue;
				int sum = arr[i][j]+arr[i][j1]+arr[i1][j]+arr[i1][j1];
				if(ans < sum) {
					ans = sum;
				}
			}
		}
		
		// 나머지 - 가로
		for(int i=0; i<n; i++) {
			int i1 = i+1;
			if(i1>=n) continue;
			for(int j=0; j<m; j++) {
				int j1 = j+1;
				int j2 = j+2;
				if(j1>=m || j2>=m) continue;
				
				int sum = arr[i][j]+arr[i][j1]+arr[i][j2]
						+ arr[i1][j];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = 						arr[i][j2]
					+ arr[i1][j]+arr[i1][j1]+arr[i1][j2];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = arr[i][j]
					+ arr[i1][j]+arr[i1][j1]+arr[i1][j2];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = arr[i][j]+arr[i][j1]+arr[i][j2]
										+arr[i1][j2];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = 				+arr[i][j1]+arr[i][j2]
						+ arr[i1][j]+arr[i1][j1];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = 	arr[i][j]+arr[i][j1]
								+arr[i1][j1]+arr[i1][j2];
				if(ans < sum) {
					ans = sum;
				}
					
				sum = arr[i][j]+arr[i][j1]+arr[i][j2]
								+arr[i1][j1];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = 				arr[i][j1]
						+ arr[i1][j]+arr[i1][j1]+arr[i1][j2];
				if(ans < sum) {
					ans = sum;
				}
			}
		}
		
		// 나머지 - 세로
		for(int i=0; i<n; i++) {
			int i1 = i+1;
			int i2 = i+2;
			if(i1>=n || i2>=n) continue;
			for(int j=0; j<m; j++) {
				int j1 = j+1;
				if(j1>=m) continue;
				int sum = arr[i][j]
						+ arr[i1][j]
						+ arr[i2][j]+arr[i2][j1];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = arr[i][j]+arr[i][j1]
								+arr[i1][j1]
								+arr[i2][j1];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = 			arr[i][j1]
								+arr[i1][j1]
					 +arr[i2][j]+arr[i2][j1];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = arr[i][j]+arr[i][j1]
					+ arr[i1][j]
					+ arr[i2][j];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = arr[i][j]
					+ arr[i1][j]+arr[i1][j1]
								+arr[i2][j1];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = 			arr[i][j1]
					+ arr[i1][j]+arr[i1][j1]
					+ arr[i2][j];
					if(ans < sum) {
						ans = sum;
					}
				
				sum =			+arr[i][j1]
					+ arr[i1][j]+arr[i1][j1]
								+arr[i2][j1];
				if(ans < sum) {
					ans = sum;
				}
				
				sum = arr[i][j]
					+ arr[i1][j]+arr[i1][j1]
					+ arr[i2][j];
				if(ans < sum) {
					ans = sum;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
} 
