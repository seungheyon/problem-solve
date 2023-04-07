class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        int newPrise = price;
        for(int i=0;i<count;i++){
            sum += newPrise;
            newPrise += price;
        }
        answer = sum - money;
        if(answer<0){
            return 0;
        }
        return answer;
    }
}