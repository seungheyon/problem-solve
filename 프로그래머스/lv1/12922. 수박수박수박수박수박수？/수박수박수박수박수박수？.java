class Solution {
    public String solution(int n) {
        String answer = "";
        while(true){
            answer += "수";
            n--;
            if(n==0){
                break;
            }
            answer += "박";
            n--;
            if(n==0){
                break;
            }
        }
        return answer;
    }
}