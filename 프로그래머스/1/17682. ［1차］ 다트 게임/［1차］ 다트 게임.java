class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int prevScore = 0;
        //int score = 0;
        int[] score = new int[]{0, 0, 0};
        int idx = -1;
        int scoreflag = 0;
        for(int i=0;i<dartResult.length();i++){
            char cur = dartResult.charAt(i);
            if(cur == '1'){
                if(dartResult.charAt(i+1)=='0'){
                    idx++;
                    score[idx] = 10;
                    scoreflag = score[idx];
                    i+=1;
                    continue;
                }
            }
            
            switch(cur){
                case 'S':
                    score[idx] = scoreflag;
                    break;
                case 'D':
                    score[idx] = scoreflag*scoreflag;
                    break;
                case 'T':
                    score[idx] = scoreflag*scoreflag*scoreflag;
                    break;
                case '*':
                    score[idx] = score[idx]*2;
                    if(idx!=0){
                        score[idx-1] = score[idx-1]*2;
                    }
                    break;
                case '#':
                    score[idx] = score[idx]*(-1);
                    break;
                default:
                    idx++;
                    score[idx] = cur-'0';
                    scoreflag = score[idx];
                    break;
            }
        }
        
        // System.out.println(score[0]);
        // System.out.println(score[1]);
        // System.out.println(score[2]);
        
        return score[0]+score[1]+score[2];
    }
}