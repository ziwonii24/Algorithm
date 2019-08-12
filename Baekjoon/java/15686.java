import java.io.*;
import java.util.*;

class Pair{
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n, m;
	int[][] arr, vis, chik;
	List<Pair> chicken = new ArrayList<>();
	Stack<Pair> stack = new Stack<>();
	boolean[] check;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	int ans = 51*51;
	
	void input() {
		try {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			arr = new int[n][n];
			vis = new int[n][n];
			chik = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(row[j]);
					if(arr[i][j]==2) {
						chicken.add(new Pair(i, j));
					}
				}
			}
			check = new boolean[chicken.size()];
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void init_vis() {
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++)
				vis[i][j] = -1;
	}
	
	void init_chik() {
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++)
				chik[i][j] = 0;
	}
	
	int bfs(int x, int y) {
		init_vis();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		vis[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(vis[nx][ny]==-1) {
						vis[nx][ny]=vis[x][y]+1;
						if(arr[nx][ny]==2 && chik[nx][ny]==1) {
							return vis[nx][ny];
						}						
						q.add(new Pair(nx, ny));
					}
				}
					
			}
		}
		return 0;
	}
	
	void dfs(int x) {
		if(stack.size()==m) {
			init_chik();
			for(Pair p: stack) {
//				System.out.print("("+p.x+", "+p.y+")");
				chik[p.x][p.y] = 1; 
			}
//			System.out.println();
			
			int chicken_sum = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]==1) {
						chicken_sum += bfs(i, j);
					}
				}
			}
			if(ans > chicken_sum) {
				ans = chicken_sum;
			}
			
			return;
		}
		
		for(int i=x; i<chicken.size(); i++) {
			if(!check[i]) {
				check[i] = true;
				stack.add(new Pair(chicken.get(i).x, chicken.get(i).y));
				dfs(i+1);
				stack.pop();
				check[i] = false;
			}
		}
	}
	
	void solve() {
		input();
		dfs(0);
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
