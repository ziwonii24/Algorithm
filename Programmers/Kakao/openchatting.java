import java.util.*;
class Solution {
    class UserState {
		String id;		// userid
		String state;	// enter, leave
		public UserState(String id, String state) {
			this.id = id;
			this.state = state;
		}		
	}
	
	StringBuilder sb = new StringBuilder();
	Map<String, String> map = new HashMap<>();	// id, name
	List<UserState> usList = new ArrayList<>();		// id, state
	
	public void solve(String[] record) {
		String state, id, name="";
		for(String cmd: record) {
			String[] str = cmd.split(" ");
			state = str[0]; id = str[1]; 
			if(str.length==3) {
				name = str[2];
			}
			
			switch(state) {
			case "Enter":
				usList.add(new UserState(id, state));
				map.put(id, name);
				break;
			case "Leave":
				usList.add(new UserState(id, state));
				break;
			case "Change":
				map.put(id, name);
				break;
			}
		}
	}
    
    public String[] solution(String[] record) {
		solve(record);
		int size = usList.size();
        String[] answer = new String[size];       
        for(int i=0; i<size; i++) {
        	String id = usList.get(i).id;
        	String state = usList.get(i).state;
        	if(state.equals("Enter")) {
        		answer[i] = map.get(id)+"님이 들어왔습니다.";
        	} else {
        		answer[i] = map.get(id)+"님이 나갔습니다.";
        	}
        }
        return answer;
    }
}
