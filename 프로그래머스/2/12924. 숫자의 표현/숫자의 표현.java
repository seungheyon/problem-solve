class Solution {
    public int solution(int n) {
        int answer = 1;
        int s = 1;
        int e = 2;
        int sum = s+e;
        while(s<n/2+1){
            if(sum<n){
                e++;
                sum+=e;
            }
            else{
                if(sum==n){
                    //System.out.println("s: "+s+", e: "+e);
                    answer++;
                }
                // s == e-1 이면 break;
                sum-=s;
                s++;
            }
        }
        
        return answer;
    }
}