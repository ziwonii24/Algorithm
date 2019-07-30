import java.io.*;
import java.util.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int n, m, x, y, k;
	int[][] map, dice;
	
	int moving(int d) {
//		System.out.println("d="+d);
		// 1. 주사위 굴리기
		int nx = x;
		int ny = y;
		
		if(d==1) {			// 동
			ny = y + 1;
			if(ny<0 || ny>=m) {
				return -1;
			}
			int tmp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = tmp;
		} else if(d==2) {	// 서
			ny = y - 1;
			if(ny<0 || ny>=m) {
				return -1;
			}
			int tmp = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = tmp;
		} else if(d==3) {	// 북
			nx = x - 1;
			if(nx<0 || nx>=n) {
				return -1;
			}
			int tmp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = tmp;
		} else {			// 남
			nx = x + 1;
			if(nx<0 || nx>=n) {
				return -1;
			}
			int tmp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = tmp;
		}
		
//		System.out.println("===dice===");
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print(dice[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		// 2. 번호 복사
		if(map[nx][ny]==0) {
			map[nx][ny] = dice[1][1];
		} else {
			dice[1][1] = map[nx][ny];
			map[nx][ny] = 0;
		}
		x=nx; y=ny;
//		System.out.println("현재 주사위 위치 : ("+x+", "+y+")");
//		
//		System.out.println("===바뀐 주사위 상황===");
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		return dice[3][1];
	}
	
	void solve() {
		try {
			String[] nmxyk = br.readLine().split(" ");
			n = Integer.parseInt(nmxyk[0]);
			m = Integer.parseInt(nmxyk[1]);
			x = Integer.parseInt(nmxyk[2]);
			y = Integer.parseInt(nmxyk[3]);
			k = Integer.parseInt(nmxyk[4]);
			map = new int[n][m];
			dice = new int[4][3];
			
			for(int i=0; i<n; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			String[] cmd = br.readLine().split(" ");
			for(int c=0; c<k; c++) {
				int d = Integer.parseInt(cmd[c]);
				int result = moving(d);
//				System.out.println("주사위 상단 = "+result);
				if(result!=-1) {
					sb.append(result +"\n");
				}
			}
			
			System.out.println(sb);
			
		} catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
