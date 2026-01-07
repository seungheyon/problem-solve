import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> mj = new LinkedList<>();
        mj.add(score[0]);
        answer[0] = score[0];
        
        for(int i=1;i<score.length;i++){
            boolean inserted = false;
            for(int j=0;j<mj.size();j++){
                if(score[i]>mj.get(j)){
                    mj.add(j, score[i]);
                    inserted = true;
                    break;
                }
            }
            if(mj.size()>k){
                    mj.remove(k);
                }
            if(!inserted){
                if(mj.size()<k){
                    mj.add(score[i]);
                }
            }
            //System.out.println(mj);
            answer[i] = mj.get(mj.size()-1);
        }
        
        
        System.out.println(mj);
        
        return answer;
    }
}