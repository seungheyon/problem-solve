import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(n>0){
            arr.add((int) (n%10));

            n /= 10;
        }
        arr.sort(Comparator.reverseOrder());
        for(int i=0;i<arr.size();i++){
            if(i>0){
                answer *= 10;
            }
            answer += arr.get(i);
        }
        return answer;
    }
}