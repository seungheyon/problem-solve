class Solution {
    public int solution(int n) {
        int answer = 2;
        for(int i=5;i<=n;i++){
            for(int j=2;j*j<=i;j++){
                if(i%j==0){

                    break;
                }
                if((j+1)*(j+1)>i){
                    //System.out.println(i+" "+j);
                    answer++;
                }
            }

        }
        if(n==2){
            answer = 1;
        }
        return answer;
    }
}