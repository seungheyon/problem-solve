class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0;i<timelogs.length;i++){
            int gg = 0;
            for(int j=0;j<timelogs[0].length;j++){
                if((j+startday)%7==6||(j+startday)%7==0){
                    continue;
                }
                int deadline = getDeadLine(schedules[i]);
                if(timelogs[i][j]<=deadline){
                    gg++;
                }
                if(gg==5){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private int getDeadLine(int num){
        if(num%100>49){
            return num+50;
        }
        return num+10;
    }
}