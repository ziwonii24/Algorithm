import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m;
	int[][] G;
	boolean[] vis;
	int ans = 0;
	
	private class Edge {
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
		
	void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)->Integer.valueOf(o1.weight).compareTo(o2.weight));
		
		int cur = 0;	// 몇번 수행할거다
		int sv = 1;		// 시작 정점
		vis[sv] = true;
		
		while(cur < n) {
			cur++;
			for(int i=1; i<=n; i++) {
				if(G[sv][i] != 0) {
					pq.add(new Edge(sv, i, G[sv][i]));
				}
			}	
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				int nv = edge.to;
				if(!vis[nv]) {
					vis[nv] = true;
					sv = nv;
					ans += edge.weight;
					break;
				}
			}
			
		}
	}
	
	void input(int i, int j, int w) {
		G[i][j] = w;
		G[j][i] = w;
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		G = new int[n+1][n+1];
		vis = new boolean[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));			
		}
		
		prim();
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
