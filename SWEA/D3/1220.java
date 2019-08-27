import java.util.*;
import java.io.*;

class Node {
	int x, y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[][] arr;
	
	void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	int count() {
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1 && arr[i+1][j]==2) { 
					cnt+=1;
				}
			}
		}
		
		return cnt;
	}
	
	void solve() throws IOException {		
		for(int tc=1; tc<=10; tc++) {
			init();
			boolean isMoved = true;
			while(isMoved) {
				isMoved = false;
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(arr[i][j]==1) { 			// N은 아래로
							if(i+1==n) {			// 아래가 밖이면 없애기
								isMoved = true;
								arr[i][j] = 0;
								continue; 
							}
							if(arr[i+1][j]==0) {	// 아래가 비어있으면 이동
								isMoved = true;
								arr[i+1][j] = arr[i][j];
								arr[i][j] = 0;
							}
						} else if(arr[i][j]==2)	 {	// S는 위로
							if(i-1<0) {				// 위가 밖이면 없애기
								isMoved = true;
								arr[i][j] = 0;
								continue; 
							}
							if(arr[i-1][j]==0) {	// 위가 비어있으면 이동
								isMoved = true;
								arr[i-1][j] = arr[i][j];
								arr[i][j] = 0;
							}
						}
					}
				}
			}
			int ans = count();
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
