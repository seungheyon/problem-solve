class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zero = 0;
        for(int i=0;i<lottos.length;i++){
            for(int j=0;j<win_nums.length;j++){
                if(lottos[i]==win_nums[j]){
                    cnt++;
                }
            }
            if(lottos[i]==0){
                zero++;
            }
        }
        int[] answer = new int[2];
        answer[0] = 7-(cnt+zero);
        answer[1] = 7-(cnt);
        if(cnt==0){
            answer[1]--;
            if(zero==0){
                answer[0]--;
            }
        }
        return answer;
    }
}