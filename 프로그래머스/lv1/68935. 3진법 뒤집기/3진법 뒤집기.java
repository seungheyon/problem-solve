class Solution {
    public int solution(int n) {
       
        String str = "";
        int size = 1;
        int firstCount = 1;

        int reps = 3;   // 3의 제곱수로 나누기 위한 변수
        while(reps<=n){
            size++;
            reps *= 3;
        }
        reps /= 3;


       while(size!=0){
           if(reps*2<=n){       // 자리수에 2가 들어감
               str += "2";
               n -= reps*2;
           }
           else if(reps<=n){    // 자리수에 1이 들어감
               str += "1";
               n -= reps;
           }
           else{                // 자리수에 0이 들어감
               str += "0";
           }
           reps /= 3;
           size--;
       }

        int ret = 0;
        int raps = 1;
        for(int i=0;i<str.length();i++){
            ret += raps*(str.charAt(i)-48);
            raps *=3;
        }
        
        int answer = ret;
        return answer;
    }
}