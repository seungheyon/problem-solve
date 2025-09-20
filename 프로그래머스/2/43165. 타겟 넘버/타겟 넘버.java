class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        search(0, numbers, target, 0);
        return answer;
    }
    
    private void search(int i, int[] numbers, int target, int cur){
        if(i==numbers.length){
            if(cur==target){
                answer++;
            }
            return;
        }
        search(i+1, numbers, target, cur+numbers[i]);
        search(i+1, numbers, target, cur-numbers[i]);
    }
}