class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[][] attemp = new int[N+2][2];
        double[][] rate = new double[N+1][2];

        for(int i=0;i<stages.length;i++){
            for(int j=1;j<=stages[i];j++){
                //System.out.println(stages[i]);
                attemp[j-1][0] +=1;     // 도달했지만 클리어 x
                attemp[j][1] +=1;     // 도달했고 클리어 O
            }
        }
        String strArr[] = new String[N];
        for(int i=1;i<=N;i++){
            attemp[i][0] = attemp[i][1] - attemp[i][0];
            if(attemp[i][1]==0){
                rate[i-1][0] = 0;
            }
            else {
                rate[i-1][0] = (double)attemp[i][0]/attemp[i][1];
            }
            rate[i-1][1] = i;
            strArr[i-1] = Double.toString(rate[i-1][0]);
        }



        for(int i=0;i<N;i++){
            int max = i;
            for(int j=i;j<N;j++){
                if(rate[j][0]>=rate[max][0]){
                    if(rate[j][0]==rate[max][0]){
                        if(rate[j][1]>=rate[max][1]){
                            continue;
                        }
                    }
                    max = j;
                }
            }
            double temp = rate[i][0];
            double temp2 = rate[i][1];
            rate[i][0] = rate[max][0];
            rate[i][1] = rate[max][1];
            rate[max][0] = temp;
            rate[max][1] = temp2;

        }
        for(int i=0;i<N;i++){
            //System.out.print((int)rate[i][1]+"   ");
            //System.out.println(rate[i][0]);
            answer[i] = (int)rate[i][1];
        }
        return answer;
    }
}