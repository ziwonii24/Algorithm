import java.util.*;
import java.io.*;

class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	int[][] arr;
	List<Pair> vp = new ArrayList<>();
	Stack<Integer> stack  = new Stack<>();
	boolean[] check;
	Queue<Pair> q = new LinkedList<>();
	int[][] vis;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int ans = Integer.MAX_VALUE;
	
	void init() {
		try {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			vis = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) {
						vp.add(new Pair(i, j));
						arr[i][j] = 0;
					}
				}
			}
			check = new boolean[vp.size()];
			
		} catch(IOException e) {}
	}
	
	void time() {
		int max = vis[0][0];
		boolean flag = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(vis[i][j]==-1 && arr[i][j]==0) {
					flag = true;
				}
				max = max<vis[i][j]?vis[i][j]:max;
			}
		}
		if(!flag) {
			ans = max<ans?max:ans;
		}
//		System.out.println("ans="+ans);
	}
	
	void bfs() {		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
//			if(vis[x][y]==-1) 
//				vis[x][y] = 0;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(vis[nx][ny]==-1 && arr[nx][ny]==0) {
						vis[nx][ny] = vis[x][y] + 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}	
	
	void dfs(int x) {
		if(stack.size()==m) {
			for(int i=0; i<n; i++)
				Arrays.fill(vis[i], -1);
//			System.out.print("virus : ");
			for(int item: stack) {
//				System.out.print("("+vp.get(item).x+", "+vp.get(item).y+")");
				q.add(new Pair(vp.get(item).x, vp.get(item).y));
				vis[vp.get(item).x][vp.get(item).y] = 0;
			}
//			System.out.println();
			bfs();
			System.out.println("===vis===");
			print(vis);
			time();
		}
		
		for(int i=x; i<vp.size(); i++) {
			if(!check[i]) {
				check[i] = true;
				stack.add(i);
				dfs(i+1);
				stack.pop();
				check[i] = false;
			}
		}
	}
	
	void solve() {
		init();
		dfs(0);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
	
	void print(int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==-1) System.out.print("- ");
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Main().solve();
	}
}
