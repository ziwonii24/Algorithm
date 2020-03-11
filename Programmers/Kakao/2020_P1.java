import java.util.*;

public class Solution_Programmers {
		
	public int solution(String s) {
		
		int sLen = s.length();	
		int answer = sLen;
		
		for(int i=1; i<=sLen/2; i++) {
			
			String resultStr = "";
			String tmpStr = s.substring(0, i);
			int cnt = 1;
			String nextStr = "";
			
			int j;
			for(j=i; j+i<=sLen; j+=i) {
				
				nextStr = s.substring(j, j+i);
				if(tmpStr.equals(nextStr)) {
					cnt += 1;
					
				} else {
					if(cnt != 1) {
						resultStr += cnt;
						cnt = 1;
					}
					resultStr += tmpStr;
					tmpStr = nextStr;
				}
			}
			
			System.out.println("j = " + j);
			
			if(cnt != 1) {
				resultStr += cnt;
				resultStr += tmpStr;
			} else {
				resultStr += nextStr;
			}
			
			if(j < sLen) {
				resultStr += s.substring(j, sLen);
			}
			
			System.out.println("resultStr = " + resultStr);
			answer = answer <= resultStr.length() ? answer : resultStr.length();
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_Programmers sp = new Solution_Programmers();
		System.out.println(sp.solution("ababcdcdababcdcd"));
	}
}
