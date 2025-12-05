import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        //int[] answer = {};
        List<Integer> answers = new ArrayList<>();
        
        boolean[][] v = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='X'){
                    v[i][j] = true;
                }
                else{
                    v[i][j] = false;
                }
            }
        }
        
        Queue<Integer[]> que = new LinkedList<>();
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)!='X'&&!v[i][j]){
                    int island = 0;
                    que.add(new Integer[]{i, j});
                    v[i][j] = true;
                    while(!que.isEmpty()){
                        int s = que.size();
                        for(int k=0;k<s;k++){
                            Integer[] cur = que.poll();
                            island += maps[cur[0]].charAt(cur[1])-48;
                            if(cur[1]<maps[0].length()-1&&maps[cur[0]].charAt(cur[1]+1)!='X'&&!v[cur[0]][cur[1]+1]){
                                que.add(new Integer[]{cur[0], cur[1]+1});
                                v[cur[0]][cur[1]+1] = true;
                            }
                            if(cur[1]>0&&maps[cur[0]].charAt(cur[1]-1)!='X'&&!v[cur[0]][cur[1]-1]){
                                que.add(new Integer[]{cur[0], cur[1]-1});
                                v[cur[0]][cur[1]-1] = true;
                            }
                            if(cur[0]>0&&maps[cur[0]-1].charAt(cur[1])!='X'&&!v[cur[0]-1][cur[1]]){
                                que.add(new Integer[]{cur[0]-1, cur[1]});
                                v[cur[0]-1][cur[1]] = true;
                            }
                            if(cur[0]<maps.length-1&&maps[cur[0]+1].charAt(cur[1])!='X'&&!v[cur[0]+1][cur[1]]){
                                que.add(new Integer[]{cur[0]+1, cur[1]});
                                v[cur[0]+1][cur[1]] = true;
                            }
                        }
                    }
                    // for(int h=0;h<maps.length;h++){
                    //     for(int g=0;g<maps[0].length();g++){
                    //         System.out.print(v[h][g]+" ");
                    //     }
                    //     System.out.println();
                    // }
                    // System.out.println();
                    
                    answers.add(island);
                }
            }
        }
        if(answers.size()==0){
            return new int[]{-1};
        }
        
        Collections.sort(answers);
        int[] answer = new int[answers.size()];
        for(int i=0;i<answers.size();i++){
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
}