import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int k=0; k<moves.length; k++) {
        	int target = moves[k];
        	int catched = 0;
        	
        	for(int i=0; i<board.length; i++) {
        		if(board[i][target-1] != 0) {
	        		catched = board[i][target-1];
	        		board[i][target-1] = 0;
	        		break;
        		}
        	}
        	
        	if(catched != 0) {
        		if(!stack.isEmpty()) {
	        		int top = stack.pop();
	        		if(top == catched) {
	        			answer += 2;
	        		} else {
	        			stack.add(top);
	        			stack.add(catched);
	        		}
	        		
        		} else {
        			stack.add(catched);
        		}
        	}
        }
        
        
        return answer;
    }
}
