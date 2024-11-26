class Solution {
    int ans = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        search(0, numbers, target, 0);
        return ans;
    }
    
    private void search(int i, int[] numbers, int target, int cur){
        
        if(i==numbers.length){
            //System.out.println(cur);
            if(cur==target){
                ans++;
            }
            return;
        }
        search(i+1,numbers, target, cur+numbers[i]);
        search(i+1,numbers, target, cur-numbers[i]);
    }
}