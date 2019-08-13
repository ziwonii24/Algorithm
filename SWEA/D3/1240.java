import java.util.*;
import java.io.*;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	String scan;
	Map<String, Integer> map = new HashMap<>();
	
	void init_map() {
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);		
	}
	
	int validating() {
		// 암호숫자는 무조건 1로 끝나니까, 마지막 1 찾기
		int last_idx = 0;
		for(int i=m-1; i>=0; i--) {
			if(scan.charAt(i)=='1') {
				last_idx = i;
				break;
			}
		}
		
		int[] code = new int[9];
		int idx = 1;	// 코드 인덱스 1부터 시작
		int start_idx = last_idx - 56 + 1;	// 암호문 시작인덱스
		for(int i=start_idx; i<=last_idx; i+=7) {
			String row = "";
			for(int j=i; j<i+7; j++) {
				row += scan.charAt(j);
			}
			code[idx++] = map.get(row);
		}
		
		int odd=0, even=0;
		for(int i=1; i<=7; i++) {
			if(i%2==1) {	// odd
				odd += code[i];
			} else {	// even
				even += code[i];
			}
		}
		
		int ans = 0;
		int calc = odd*3 + even + code[8];
		if(calc % 10 == 0) {
			for(int i=1; i<=8; i++) {
				ans += code[i];
			}
		} else {
			ans = 0;
		}
		
		return ans;
	}
		
	void solve() {
		init_map();
		try {
			int testcase = Integer.parseInt(br.readLine());
			for(int tc=1; tc<=testcase; tc++) {
				st = new StringTokenizer(br.readLine(), " ");
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				for(int i=0; i<n; i++) {
					String row = br.readLine();
					if(row.contains("1")) {
						scan = row;
					}
				}
						
				int ans = validating();
				sb.append("#").append(tc).append(" ").append(ans).append("\n");
			}
			System.out.println(sb);
			
		} catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
