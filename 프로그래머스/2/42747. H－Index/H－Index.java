import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int h = 0;
        int paper = citations.length;
        //int citation = 
        for(int a : citations){
            if(paper <= a){
                return paper;
            }
            // if(paper<a){
            //     return paper;
            // }
            paper-- ;
        }
        
        return answer;
    }
}