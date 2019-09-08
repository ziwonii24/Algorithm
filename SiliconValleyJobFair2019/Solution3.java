class Solution {
    public int solution(int[] estimates, int k) {
        int n = estimates.length;
		int[] sum = new int[n];
		sum[0] = estimates[0];
		int answer = sum[0];		
		for(int i=1; i<n; i++) {
			sum[i] = sum[i-1] + estimates[i];
			if(i-k >= 0) {
				sum[i] -= estimates[i-k];
			}
			answer = answer<sum[i]?sum[i]:answer;
		}
		
		return answer;
    }
}
