class Solution {
  public static String solution(int n, int t, int m, int p) {
        String answer = "";
        Long order = 0L;

        Integer num = -1;
        while(true){
            num++;
            String numStr = Integer.toString(num, n).toUpperCase();
            for(int i=0;i<numStr.length();i++){
                order++;
                if(order==p){
                    answer += numStr.substring(i,i+1);
                }
                if(order==m){
                    order=0L;
                }
                if(answer.length()==t){
                    return answer;
                }
            }
        }
    }
}