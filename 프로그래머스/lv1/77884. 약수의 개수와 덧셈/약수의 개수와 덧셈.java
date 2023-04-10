class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int cnt = 0;
        for(int num = left;num<=right;num++){
            for(int i=1;i*i<=num;i++){
                if(num%i==0){
                    cnt+=2;
                    if(i*i==num){
                        cnt --;
                    }
                }
            }
            if(cnt%2==0){
                answer += num;
            }
            else{
                answer -=num;
            }
            cnt=0;
            //System.out.println(num+" "+cnt);
        }
        return answer;
    }
}