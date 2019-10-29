import java.io.*;
import java.util.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[][] arr, res;
	
	void moving(String cmd) {
		int idx = 0;
		int tmp = -1;
		
		if(cmd.equals("left")) {
			for(int i=0; i<n; i++) {
				idx = 0;
				tmp = -1;
				for(int j=0; j<n; j++) {
					if(arr[i][j] == 0) continue;
					if(tmp == -1) {
						tmp = arr[i][j];
						continue;
					}
					if(tmp == arr[i][j]) {
						res[i][idx++] = tmp + arr[i][j];
						tmp = -1;
					} else {
						res[i][idx++] = tmp;
						tmp = arr[i][j];
					}
				}
				if(tmp != -1) {
					res[i][idx] = tmp;
				}
			}
		}
		else if(cmd.equals("right")) {
			for(int i=0; i<n; i++) {
				idx = n-1;
				tmp = -1;
				for(int j=n-1; j>=0; j--) {
					if(arr[i][j] == 0) continue;
					if(tmp == -1) {
						tmp = arr[i][j];
						continue;
					}
					if(tmp == arr[i][j]) {
						res[i][idx--] = tmp + arr[i][j];
						tmp = -1;
					} else {
						res[i][idx--] = tmp;
						tmp = arr[i][j];
					}
				}
				if(tmp != -1) {
					res[i][idx] = tmp;
				}
			}
		}
		else if(cmd.equals("up")) {
			for(int j=0; j<n; j++) {
				idx = 0;
				tmp = -1;
				for(int i=0; i<n; i++) {
					if(arr[i][j] == 0) continue;
					if(tmp == -1) {
						tmp = arr[i][j];
						continue;
					}
					if(tmp == arr[i][j]) {
						res[idx++][j] = tmp + arr[i][j];
						tmp = -1;
					} else {
						res[idx++][j] = tmp;
						tmp = arr[i][j];
					}
				}
				if(tmp != -1) {
					res[idx][j] = tmp;
				}
			}
		}
		else if(cmd.equals("down")) {
			for(int j=0; j<n; j++) {
				idx = n-1;
				tmp = -1;
				for(int i=n-1; i>=0; i--) {
					if(arr[i][j] == 0) continue;
					if(tmp == -1) {
						tmp = arr[i][j];
						continue;
					}
					if(tmp == arr[i][j]) {
						res[idx--][j] = tmp + arr[i][j];
						tmp = -1;
					} else {
						res[idx--][j] = tmp;
						tmp = arr[i][j];
					}
				}
				if(tmp != -1) {
					res[idx][j] = tmp;
				}
			}
		}
	}
	
	void solve() throws  IOException {		
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			String cmd = st.nextToken();
			arr = new int[n][n];
			res = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");				
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			moving(cmd);
			
			sb.append('#').append(tc).append('\n');
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(res[i][j]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
