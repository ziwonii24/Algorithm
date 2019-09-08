import java.util.*;

class Solution {
    public String solution(String phrases, int second) {
		
		Queue<Character> q = new LinkedList<>();		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<14; i++) {
			sb.append('_');
		}
		sb.append(phrases);
		String p = sb.toString();
		
		for(char c : p.toCharArray()) {
			q.add(c);
		}
		
		int totalLen = 14 + phrases.length();
		int sec = second % totalLen;		
		for(int i=0; i<sec; i++) {
			char tmp = q.poll();
			q.add(tmp);
		}
		
		sb = new StringBuilder();
		for(int i=0; i<14; i++) {
			sb.append(q.poll());
		}
		String answer = sb.toString();	
        return answer;
    }
}
