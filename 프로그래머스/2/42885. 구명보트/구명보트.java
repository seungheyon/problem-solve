import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int len = people.length;
        
        int l = 0;
        int h = 1;
        while(true){
            while(people[l] + people[len-h]>limit && l+h<=len-1){
                //System.out.print("l : " + l);
                //System.out.println(" h : " + h);
                answer++;
                //System.out.println("a : " + answer);
                h++;
            }
            
            answer++;
            // System.out.print("l : " + l);
            // System.out.println(" h : " + h);
            // System.out.println("a : " + answer);
            l++;
            h++;
            if(l+h>len){
                break;
            }
        }
        
        return answer;
    }
}