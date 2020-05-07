import java.util.*;

class Solution {
    	public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> completed = new HashMap<>();
        
        for(int k=0; k<completion.length; k++) {
        	String key = completion[k];
        	int val = 0;
        	if(completed.containsKey(key)) {
        		val = completed.get(key);
        	}
        	completed.put(key, val+1);
        }
        
        for(int k=0; k<participant.length; k++) {
        	String p = participant[k];
        	if(!completed.containsKey(p)) {
        		answer = p;
        		break;
        	}
        	int val = completed.remove(p);
        	if(val-1 != 0) completed.put(p, val-1);
        }
        
        return answer;
    }
}
