class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[k];
        
        for(int i=0;i<24;i++){
            int cur_server = 1;
            for(int j=0;j<k-1;j++){
                servers[j] = servers[j+1];
                cur_server +=servers[j+1];
                //System.out.print(servers[j]+" ");
            }
            servers[k-1] = 0;
            
            //System.out.println();
            if(players[i]>0){
                int need_people = players[i] - cur_server*m;
                if(need_people>=0){
                    int need_server = need_people/m + 1;
                    servers[k-1] = need_server;
                    answer +=need_server;
                    //System.out.println("round:"+i+" cur_s:"+cur_server+" added server:"+need_server);
                }
            }
            
            
        }
        
        return answer;
    }
}