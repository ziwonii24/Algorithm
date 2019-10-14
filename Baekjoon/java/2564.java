import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	class Pair {
		int d, l;
		public Pair(int d, int l) {
			this.d = d;
			this.l = l;
		}
	}
	
	int min(int a, int b) {
		return a<b?a:b;
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		Pair[] store = new Pair[s];
		for(int i=0; i<s; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			store[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		Pair x = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		long ans = 0;
		for(int i=0; i<s; i++) {
			Pair p = store[i];
			
			// 서로 반대편에 있을때 (남 북)
			if((x.d==1 && p.d==2) || (x.d==2 && p.d==1)) {
				ans += min(h+x.l+p.l, h+(w-x.l)+(w-p.l));
			}
			// 서로 반대편에 있을때 (동 서)			
			else if((x.d==3 && p.d==4) || (x.d==4 && p.d==3)) {
				ans += min(w+x.l+p.l, w+(h-x.l)+(h-p.l));
			}
			// 북 - 서
			else if((x.d==1 && p.d==3) || (x.d==3 && p.d==1)) {
				ans += x.l + p.l;
			}
			// 북 - 동
			else if(x.d==1 && p.d==4) {
				ans += (w-x.l) + p.l;
			}
			
			else if(x.d==4 && p.d==1) {
				ans += x.l + (w-p.l);
			}
			// 남 - 서
			else if(x.d==2 && p.d==3) {
				ans += x.l + (h-p.l);
			}
			else if(x.d==3 && p.d==2) {
				ans += (h-x.l) + p.l;
			}
			// 남 - 동
			else if(x.d==2 && p.d==4) {
				ans += (w-x.l) + (h-p.l);
			}
			else if(x.d==4 && p.d==2) {
				ans += (h-x.l) + (w-p.l);
			}
			// 같은 라인에 있을때
			else if(x.d==p.d) {
				ans += Math.abs(x.l - p.l);
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
