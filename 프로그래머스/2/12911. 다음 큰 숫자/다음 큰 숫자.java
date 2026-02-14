class Solution {
    public int solution(int n) {
        int answer = n+1;
        
        String bnum = Integer.toBinaryString(n);
        int oneCnt = countOne(bnum);
        
        while(true){
            if(countOne(Integer.toBinaryString(answer))==oneCnt){
                return answer;
            }
            answer++;
        }
        
        //return answer;
    }
    private int countOne(String binString){
        int onecnt = 0;
        for(int i=0;i<binString.length();i++){
            if(binString.charAt(i)=='1'){
                onecnt++;
            }
        }
        return onecnt;
    }
}