
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        // int walong = (wallet[0]>=wallet[1]) ? wallet[0] : wallet[1];
        // int washort = (wallet[0]<wallet[1]) ? wallet[0] : wallet[1];
        // int billong = (bill[0]>=bill[1]) ? bill[0] : bill[1];
        // int bilshort = (bill[0]<bill[1]) ? bill[0] : bill[1];
        
        
        while(Math.min(bill[0], bill[1])>Math.min(wallet[0],wallet[1])||Math.max(bill[0], bill[1])>Math.max(wallet[0],wallet[1])){
            if(bill[0]>bill[1]){
                bill[0] = bill[0]/2;
                // bilshort = bill[0];
                // billong = bill[1];
            }
            else{
                bill[1] = bill[1]/2;
                // bilshort = bill[1];
                // billong = bill[0];
            }
            answer++;
        }
        return answer;
    }
}