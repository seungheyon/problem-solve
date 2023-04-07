import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer2 = new ArrayList<>();
        for(int a:arr){
            if(a%divisor==0){
                answer2.add(a);
            }
        }
        answer2.sort(Comparator.naturalOrder());
        if(answer2.isEmpty()){
            answer2.add(-1);
        }
        int[] answer = new int[answer2.size()];
        int i=0;
        for(int a:answer2){
            answer[i++] = a;
        }

        return answer;
    }
}