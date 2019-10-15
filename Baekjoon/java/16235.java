import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m, year;
	int[][] arr, nutri;
	final int[] dx = {0,0,1,-1,1,1,-1,-1};
	final int[] dy = {1,-1,0,0,1,-1,1,-1};
	PriorityQueue<Tree> pq = new PriorityQueue<>((o1,o2)->Integer.valueOf(o1.age).compareTo(o2.age));			
	Queue<Tree> live_trees = new LinkedList<>();
	Queue<Tree> death_trees = new LinkedList<>();
	
	private class Tree {
		int x, y, age;
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
	
	void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];		
		nutri = new int[n+1][n+1];		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				nutri[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(x, y, age));
		}
	}
	
	/**
	 * 나무가 자신의 나이만큼 양분을 먹고, 나이 1 증가
	 * 그 자리에 나무가 여러개있으면 어린나무 먼저 양분 먹기
	 * 나이만큼 양분 못 먹은 나무는 죽음
	 * */
	void spring() {
		while(!pq.isEmpty()) {
			Tree t = pq.poll();
			if(arr[t.x][t.y] < t.age) {
				death_trees.add(t);
			} else {
				arr[t.x][t.y] -= t.age;
				t.age += 1;
				live_trees.add(t);
			}
		}
	}
	
	/**
	 * 봄에 죽은 나무가 양분으로 변함(+나이/2)
	 * */
	void summer() {
		while(!death_trees.isEmpty()) {
			Tree t = death_trees.poll();
			arr[t.x][t.y] += (t.age/2);
		}
	}
	
	/**
	 * 나이가 5의배수인 나무 번식(인접한 8칸)
	 * */
	void autumn() {
		while(!live_trees.isEmpty()) {
			Tree t = live_trees.poll();
			pq.add(t);
			if(t.age % 5 == 0) {
				for(int k=0; k<8; k++) {
					int nx = t.x + dx[k];
					int ny = t.y + dy[k];
					if(nx>0 && nx<=n && ny>0 && ny<=n) {
						pq.add(new Tree(nx, ny, 1));
					}
				}
			}
		}
	}
	
	/**
	 * 양분추가
	 * */
	void winter() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] += nutri[i][j];
			}
		}
	}
	
	void solve() throws IOException {
		input();
		
		while(year-- > 0) {
			spring();
			summer();
			autumn();
			winter();
		}		
		System.out.println(pq.size());
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
