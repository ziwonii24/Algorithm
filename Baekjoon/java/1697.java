import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, k;
	int[] time = new int[100001];
	Queue<Integer> q = new LinkedList<>();
	
	int bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x==k) {
				return time[k];
			}
			
			int nx1 = x-1, nx2 = x+1, nx3 = x*2;
			if(nx1>=0) {
				if(time[nx1]==-1 || time[x]+1 < time[nx1]) {
					time[nx1] = time[x] + 1;
					q.add(nx1);
				}
			}
			if(nx2<time.length) {
				if(time[nx2]==-1 || time[x]+1 < time[nx2]) {
					time[nx2] = time[x] + 1;
					q.add(nx2);
				}
			}
			if(nx3<time.length) {
				if(time[nx3]==-1 || time[x]+1 < time[nx3]) {
					time[nx3] = time[x] + 1;
					q.add(nx3);
				}
			}
		}
		
		return 0;
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Arrays.fill(time, -1);
		time[n] = 0;
		q.add(n);
		int ans = bfs();
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
