import java.util.*;
class Solution {
    public String solution(String s) {
        //String answer = "";
        int min = 0;
        int max = 0;
        String[] words = s.split(" ");
        
        for(int i=0;i<words.length;i++){
            int val = Integer.parseInt(words[i]);
            if(i==0){
                min = val;
                max = val;
            }
            else{
                if(val>max){
                    max = val;
                }
                if(val<min){
                    min = val;
                }
            }
        }
        
        
        return Integer.toString(min)+" "+Integer.toString(max);
    }
}