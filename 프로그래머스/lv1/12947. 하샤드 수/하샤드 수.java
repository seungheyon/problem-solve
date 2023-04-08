class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int n = x;
        int div = 0;
        while(n>0){
            div += n%10;
            n /= 10;
        }
        if(x%div!=0){
            answer = false;
        }        
        return answer;
    }
}