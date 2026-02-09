class Solution {
    public int solution(String s) {
        int answer = 0;
        int pivcnt = 0;
        int comp = 0;
        char piv = s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(pivcnt==0){
                piv = s.charAt(i);
                pivcnt++;
                continue;
            }
            if(s.charAt(i)==piv){
                pivcnt++;
            }
            else{
                comp++;
            }
            if(pivcnt==comp){
                answer++;
                pivcnt = 0;
                comp = 0;
                //System.out.println(s.charAt(i));
            }
        }
        if(pivcnt!=0){
            answer++;
        }
        return answer;
    }
}