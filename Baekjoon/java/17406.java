import java.io.*;
import java.util.*;

class Cmd {
	int r;
	int c;
	int s;
	public Cmd(int r, int c, int s) {
		this.c = c;
		this.r = r;
		this.s = s;
	}
}

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m, k, r, c, s;
	int[][] arr, carr;
	Cmd[] command = new Cmd[7];
	Stack<Integer> stack = new Stack<>();
	boolean[] check = new boolean[7];
	int ans = Integer.MAX_VALUE;
	
	void init() {
		try {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n+1][m+1];
			carr = new int[n+1][m+1];
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					carr[i][j] = arr[i][j];
				}
			}
			for(int i=1; i<=k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				command[i] = new Cmd(r, c, s);
			}
		} catch(IOException e) {}
	}
	
	void copy_arr() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				arr[i][j] = carr[i][j];
			}
		}
	}
	
	void operating(int idx) {
//		System.out.println("idx="+idx);
		// 경계좌표
		int sx = command[idx].r - command[idx].s;
		int sy = command[idx].c - command[idx].s;
		int ex = command[idx].r + command[idx].s;
		int ey = command[idx].c + command[idx].s;
		
		// 현재좌표
		int x = sx;
		int y = sy;
		int d = 0;	// 0123 : 동남서북
		
		int cur = arr[x][y];
		int nx = x;
		int ny = y;
		
		while(true) {
//			System.out.println("x="+x+", y="+y+", d="+d);			
			
			if(d==0) {
				ny+=1;				
			} else if(d==1) {
				nx+=1;
			} else if(d==2) {
				ny-=1;
			} else {
				nx-=1;
			}
			
			if(nx>=sx && nx<=ex && ny>=sy && ny<=ey) {
				int tmp = arr[nx][ny];
				arr[nx][ny] = cur;
				cur = tmp;
				x=nx;
				y=ny;
			} else {
				nx=x;
				ny=y;
				d++;
				if(d==4) d=0;
			}
			
			if(x==sx && y==sy) {
				sx+=1;
				sy+=1;
				ex-=1;
				ey-=1;
				x=sx;
				y=sy;
				nx=x;
				ny=y;
				d=0;
				cur = arr[x][y];
//				System.out.println("sx="+sx+", sy="+sy+", ex="+ex+", ey="+ey);
			}
			
			if((sx==ex && sy==ey) || (ex-sx==1 && ey-sy==1)) {
				break;
			}
		}	
		
//		System.out.println("======");
//		print(arr);
	}
	
	void calc() {
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=1; j<=m; j++) {
				sum += arr[i][j];
			}
			if(sum < ans) {
				ans = sum;
//				System.out.println("sum="+sum+", ans="+ans);
			}
		}
	}
	
	void dfs() {	// 연산 순서 인덱스로 구하기
		if(stack.size()==k) {
//			System.out.print("stack=[");
//			for(int s: stack) {
//				System.out.print(s+" ");
//			}
//			System.out.println("]");
			
			copy_arr();
			for(int s: stack) {
				operating(s);
			}
			calc();
			return;
		}
		
		for(int i=1; i<=k; i++) {
			if(!check[i]) {
				check[i] = true;
				stack.add(i);
				dfs();
				stack.pop();
				check[i] = false;
			}
		}
	}
	
	void solve() {
		init();
		dfs();
		System.out.println(ans);
	}
	
	void print(int[][] arr) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
