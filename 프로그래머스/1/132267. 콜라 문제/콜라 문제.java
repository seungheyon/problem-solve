class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int mod = 0;
        int mycoke = n;
        int curcoke = n;
        
        while(true){
            curcoke = ((mycoke+mod)/a)*b;
            mod = (mycoke+mod)%a;
            if(curcoke==0){
                return answer;
            }
            answer +=curcoke;
            mycoke = curcoke;         
        }
        
        //return answer;
    }
}