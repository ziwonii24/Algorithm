import java.util.*;
import java.io.*;

/**bfs dfs graph*/
public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	boolean[][] graph;
	int[] people;
	List<Integer> area1 = new ArrayList<>();
	List<Integer> area2 = new ArrayList<>();
	boolean[] check;
	int ans = Integer.MAX_VALUE;
	
	boolean isConnected(List<Integer> list) {
		boolean[] vis = new boolean[n+1];		
		Queue<Integer> q = new LinkedList<>();
		q.add(list.get(0));
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int x = q.poll();
			vis[x] = true;
			for(int i: list) {
				if(!vis[i] && graph[x][i]) {
					vis[i] = true;
					q.add(i);
					cnt++;
				}
			}
		}
    
		if(cnt == list.size()) {
			return true;
		}	
		
		return false;
	}
	
	int diff() {
		int res = 0;
		for(int item: area1) {
			res += people[item];
		}
		for(int item: area2) {
			res -= people[item];
		}
		return Math.abs(res);
	}
	
	void comb(int t, int x) {
		if(area1.size()==t) {
			area2.clear();
			for(int i=1; i<=n; i++) {
				if(!check[i]) {
					area2.add(i);
				}
			}			
			
			if(isConnected(area1) && isConnected(area2)) {
				int res = diff();
				if(res < ans) {
					ans = res;
				}
			}
			return;
		}
		
		for(int i=x; i<=n; i++) {
			if(!check[i]) {
				check[i] = true;
				area1.add(i);
				comb(t, i+1);
				check[i] = false;
				area1.remove(area1.size()-1);
			}
		}
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		graph = new boolean[n+1][n+1];
		people = new int[n+1];
		check = new boolean[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for(int from=1; from<=n; from++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int k=0; k<cnt; k++) {
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = true;
			}
		}
		
		for(int i=1; i<n; i++) {
			comb(i, 1);
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
