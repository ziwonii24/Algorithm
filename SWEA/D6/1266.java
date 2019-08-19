import java.util.*;
import java.io.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int[] prime = {2,3,5,7,11,13,17};
	
	double comb(int r, int p) {
		// 18Cr
		double up=1, down=1;
		for(int i=18; i>18-r; i--) {
			up *= i;
		}
		for(int i=1; i<=r; i++) {
			down *= i;
		}
		double c = up/down;
				
		double res1 = 1;
		for(int i=1; i<=r; i++) {
			res1 *= p/100.0;
		}		
		
		double res2 = 1;
		for(int i=1; i<=18-r; i++) {
			res2 *= (100-p)/100.0;
		}
		
		return c*res1*res2;
	}
	
	void solve() {
		try {
			int testcase = Integer.parseInt(br.readLine());
			for(int tc=1; tc<=testcase; tc++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				double suma=0, sumb=0;
				for(int i=0; i<prime.length; i++) {
					suma += comb(prime[i], a);
					sumb += comb(prime[i], b);
				}
				
				double ans = (suma+sumb) - (suma*sumb);
				sb.append("#").append(tc).append(" ");
				if(ans==0.0) {
					sb.append("0.000000");
				} else {
					ans *= 1000000;
					ans = Math.round(ans);
					ans /= 1000000;
					sb.append(ans);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		} catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
