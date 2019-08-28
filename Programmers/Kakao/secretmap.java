class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      // 비트 연산 : 논리합 | 
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = arr1[i] | arr2[i];         
        }

        // 10진수 -> 2진수
        String[] tmp = new String[n];
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            String binaryStr = Integer.toBinaryString(res[i]);
            for(int k=0; k<n-binaryStr.length(); k++)
                sb.append("0");
            sb.append(binaryStr);
            tmp[i] = sb.toString();
        }

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(char c: tmp[i].toCharArray()) {
                if(c=='1') sb.append("#");
                else if(c=='0') sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
  }
}
