import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> intSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            intSet.add(nums[i]);
        }
        if(nums.length/2<intSet.size()){
            answer = nums.length/2;
        }
        else {
            answer = intSet.size();
        }
        
        return answer;
    }
}