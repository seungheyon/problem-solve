import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int tlen = t.length();
        int plen = p.length();
        Long pnum = Long.parseLong(p);
        
        int start = 0;
        int end = plen;
        
        while(end<=tlen){
            Long tnum = Long.parseLong(t.substring(start, end));
            if(tnum<=pnum){
                answer++;
            }
            start++;
            end++;
        }
        
        return answer;
    }
}