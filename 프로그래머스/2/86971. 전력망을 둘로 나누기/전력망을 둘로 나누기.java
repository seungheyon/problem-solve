import java.util.*;
class Solution {
    private int nodes = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        boolean[] done = new boolean[wires.length];
        int minSub = 100;
        for(int[] wire : wires){
            nodes = 0;
            getNet(wire[0], wire[1], wires, done);
            int leftNodes = nodes;
            System.out.println("left : " + leftNodes);
            Arrays.fill(done, false);
            nodes = 0;
            getNet(wire[1], wire[0], wires, done);
            int rightNodes = nodes;
            Arrays.fill(done, false);
            System.out.println("right : " + rightNodes);
            int sub = Math.abs(leftNodes - rightNodes);
            minSub = Math.min(minSub, sub);
        }
        
        return minSub;
    }
    
    private void getNet(int a, int b, int[][] wires, boolean[] done){
        nodes++;
        for(int i=0;i<wires.length;i++){
            if((wires[i][0]==a || wires[i][1]==a)&&!done[i]){
                if(wires[i][0]==b || wires[i][1]==b){
                    //nodes--;
                    continue;
                }
                done[i] = true;
                if(wires[i][0]==a){
                    getNet(wires[i][1], b, wires, done);
                }
                else{
                    getNet(wires[i][0], b, wires, done);
                }
            }
        }
    }
}
