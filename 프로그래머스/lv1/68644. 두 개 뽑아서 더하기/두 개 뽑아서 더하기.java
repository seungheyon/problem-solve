import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){

                int sum = numbers[i]+numbers[j];
                if(!arr.contains(sum)){
                    arr.add(sum);
                }
            }
        }
        arr.sort(Comparator.naturalOrder());
        int i=0;
        int[] answer = new int[arr.size()];
        for(int a:arr){
            answer[i] = a;
            i++;
        }
        return answer;
    }
}