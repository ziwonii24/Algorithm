class Solution {
    public int solution(int[][] office, int k) {
        int answer = 0;
		int n = office.length;
		for(int i=0; i<n; i++) {
			if(n < i+k) continue;			
			for(int j=0; j<n; j++) {
				// k range
				if(n < j+k) continue;
				
				int sum = 0;
				for(int u=i; u<i+k; u++) {
					for(int v=j; v<j+k; v++) {
						sum += office[u][v];
					}
				}
				answer = answer<sum?sum:answer;
			}
		}
		
		return answer;
    }
}
