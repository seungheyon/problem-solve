class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] letters = s.split(" ");
        
        boolean nowSpace = true;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                nowSpace = true;
                answer+=" ";
                continue;
            }
            else{
                if(nowSpace==true){
                    nowSpace=false;
                    answer+=String.valueOf(s.charAt(i)).toUpperCase();
                    continue;
                }
                else{
                    answer+=String.valueOf(s.charAt(i)).toLowerCase();
                    continue;
                }
            }
        }
        
        
        return answer;
    }
}