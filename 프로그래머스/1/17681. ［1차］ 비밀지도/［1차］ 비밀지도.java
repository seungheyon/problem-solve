class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] binarr = new int[n];
        boolean[][] answercop = new boolean[n][n];
        binarr[0] = 1;
        for(int i=1;i<n;i++){
            int cur = 1;
            for(int j=1;j<=i;j++){
                cur*=2;
            }
            binarr[i] = cur;
        }
        
        for(int i=0;i<n;i++){
            int[] bin1 = new int[n];
            int[] bin2 = new int[n];
            int compare1 = arr1[i];
            int compare2 = arr2[i];
            for(int j=0;j<n;j++){
                if(compare1>=binarr[n-1-j]){
                    bin1[j] = 1;
                    compare1 -= binarr[n-1-j];
                }
                else{
                    bin1[j] = 0;
                }
                if(compare2>=binarr[n-1-j]){
                    bin2[j] = 1;
                    compare2 -= binarr[n-1-j];
                }
                else{
                    bin2[j] = 0;
                }
            }
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<n;j++){
                if(bin1[j]==1||bin2[j]==1){
                    //answercop[i][j] = true;
                    sb.append("#");
                }
                else{
                    //answercop[i][j] = false;
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}