import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	class Horse {
		int x, y, d, f;
		public Horse(int x, int y, int d, int f) {
			this.x = x;	// 행
			this.y = y; // 열
			this.d = d;	// 방향
			this.f = f;	// 몇번째 층에 있니
		}
	}
	
	int n, k;
	int[][] colorMap;		// (x, y) 체스칸 색깔 : 0(흰), 1(빨), 2(파)
	Horse[] horse;			// 말의 순서(x, y, d, f)
	int[][][] horseMap;		// (x, y)[0,1,2,3]=말번호. 0이 바닥. 3에 말이 들어오게 되면 게임끝
	final int[] dx = {0,0,-1,1};
	final int[] dy = {1,-1,0,0};
	boolean gameEnd = false;
	
	void white(int x, int y, int nx, int ny, int curf) {
		// 쌓을 층수 찾기
		int nf = 0;
		for(int i=0; i<4; i++) {
			if(horseMap[nx][ny][i] == 0) {	// 아무것도 없으면 0, 있으면 말 번호
				nf = i;
				break;
			}
		}
		
		// 쌓기
		// 현재층부터 끝까지 말이 있으면 옮긴다
		for(int f=curf; f<4; f++) {
			if(nf == 4) {
				gameEnd = true;
				return;
			}
			
			int cur = horseMap[x][y][f];
			if(cur != 0) {	// 현재 위치에 말이 있으면
				horseMap[nx][ny][nf] = cur;	// 다음 위치로 이동
				horse[cur].x = nx;
				horse[cur].y = ny;
				horse[cur].f = nf;	// 말 정보 층수 업데이트
				horseMap[x][y][f] = 0;		// 원래 위치에 말 비우기
				nf += 1;	// 층수 증가
			} else {
				break;
			}
		}
		
		if(nf == 4) {
			gameEnd = true;
			return;
		}
	}
	
	void red(int x, int y, int nx, int ny, int curf) {
		// 쌓을 위치 찾기
		int nf = 0;
		for(int i=0; i<4; i++) {
			if(horseMap[nx][ny][i] == 0) {
				nf = i;
				break;
			}
		}
		
		// 쌓기
		// 현재층부터 끝까지 말이 있으면 순서를 반대로옮긴다
		for(int f=3; f>=curf; f--) {
			if(nf == 4) {
				gameEnd = true;
				return;
			}
			
			int cur = horseMap[x][y][f];
			if(cur != 0) {	// 현재 위치에 말이 있으면
				horseMap[nx][ny][nf] = cur;	// 다음 위치로 이동
				horse[cur].x = nx;
				horse[cur].y = ny;
				horse[cur].f = nf;	// 말 정보 층수 업데이트
				horseMap[x][y][f] = 0;		// 원래 위치에 말 비우기
				nf += 1;	// 층수 증가
			}
		}
		
		if(nf == 4) {
			gameEnd = true;
			return;
		}
	}
	
	void blue(int hnum, int x, int y, int d) {
		// 방향 전환
		if(d == 0) {
			horse[hnum].d = 1;
		} else if(d == 1) {
			horse[hnum].d = 0;
		} else if(d == 2) {
			horse[hnum].d = 3;
		} else if(d == 3){
			horse[hnum].d = 2;
		}
		
		int nx = x + dx[horse[hnum].d];
		int ny = y + dy[horse[hnum].d];
		
		// 이동할 수 있는지
		if(nx<0 || nx>=n || ny<0 || ny>=n) return;
		switch(colorMap[nx][ny]) {
		case 0:
			white(x, y, nx, ny, horse[hnum].f);	// 현재말의 위치,층수와 다음 위치
			break;
		case 1:
			red(x, y, nx, ny, horse[hnum].f);
			break;
		case 2: 
			return;
		} 
	}
	
	void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		colorMap = new int[n][n];
		horseMap = new int[n][n][4];
		k = Integer.parseInt(st.nextToken());
		horse = new Horse[k+1];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j=0; j<n; j++) {
				colorMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<=k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			horse[i] = new Horse(x-1, y-1, d-1, 0);
			horseMap[x-1][y-1][0] = i;	// 해당위치의 맨 바닥에 말 번호
		}
	}
	
	void solve() throws IOException {
		input();
		
		int turn = 0;
		while(++turn <= 1000) {
			
			for(int h=1; h<=k; h++) {
				int x = horse[h].x;
				int y = horse[h].y;
				int nx = x + dx[horse[h].d];
				int ny = y + dy[horse[h].d];
				
				// 다음 위치가 범위를 넘어간 경우 blue로 처리
				if(nx<0 || nx>=n || ny<0 || ny>=n) {
					blue(h, x, y, horse[h].d);
					if(gameEnd) break;
					continue;
				}
								
				switch(colorMap[nx][ny]) {
				case 0:
					white(x, y, nx, ny, horse[h].f);
					break;
				case 1:
					red(x, y, nx, ny, horse[h].f);
					break;
				case 2: 
					blue(h, x, y, horse[h].d);
					break;
				} 
				if(gameEnd) break;				
			}
			if(gameEnd) break;	
		}
		
		if(turn > 1000)
			System.out.println(-1);
		else
			System.out.println(turn);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
