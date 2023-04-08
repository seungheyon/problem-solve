class Solution {
    public int solution(int num) {
        int answer = 0;
        long nuwNum = (long) num;
        while(nuwNum!=1){
            if(nuwNum%2==0){
                nuwNum /=2;
            }
            else if(nuwNum%2 !=0) {
                nuwNum *=3;
                nuwNum +=1;
            }
            answer++;
            if(answer>500){
                answer = -1;
                return answer;
            }
        }
        return answer;
    }
}