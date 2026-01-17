import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        recursiveBin(s, answer);
        return answer;
    }
    
    private void recursiveBin(String str, int[] answer){
        if(str.equals("1")){
            return;
        }
        answer[0]++;
        int num = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                answer[1]++;
            }
            else{
                num++;
            }
        }
        recursiveBin(Integer.toBinaryString(num), answer);
    }
}