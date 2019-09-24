import java.io.*;
import java.util.*;

/**BufferedReader는 입력제한이 있음 -> Scanner로 받아서 어디다가 저장하지 말고 바로바로 처리해서 답 바로 출력*/
public class Solution {

	Scanner sc = new Scanner(System.in);
	
	void solve() throws IOException {
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
			int n = sc.nextInt();
			sc.nextLine();
			
			int k = Integer.parseInt(sc.next());
			long ans = 0;
			long l = 0, s = 0;
			
			for(int i=1; i<n; i++) {
				int next = Integer.parseInt(sc.next());
				
				boolean flag = true;				
				while(flag) {
//					System.out.println("현재=" + k);
//					System.out.println("비교대상=" + next);
					if(s==0 && k<next) {
						l += 1;
//						System.out.println("현재보다 클때 : l="+l);
						k = next;
						flag = false;
					} else if(l!=0 && k>next) {
						s += 1;
//						System.out.println("현재보다 작을때 : s="+s);
						k = next;
						flag = false;
					} else if(s!=0 && k<next) {
						// 이 경우에만 다시 비교를 시작하기 위해 while문으로 만든것
//						System.out.println("작았다가 커졌을때 : l*s="+(l*s));
						ans += l*s;
						l = 0;
						s = 0;
					} else if(l==0 && k>next) {
//						System.out.println("커지지도 않았는데 작아질때");
						k = next;
						flag = false;
					} else {		
						k = next;
						flag = false;
					}					
				}
			}
			ans += l*s;
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
