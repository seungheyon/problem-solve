import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> newArr = new ArrayList<>();
        newArr.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                continue;
            }
            newArr.add(arr[i]);
        }

        int[] answer = new int[newArr.size()];
        int i=0;
        for(int a:newArr){
            answer[i] = a;
            i++;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");

        return answer;
    }
}