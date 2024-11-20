import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        
        List<int[]> dp = new ArrayList<>();
        
        int[] fArr = new int[triangle.length];
        fArr[0] = triangle[0][0];
        dp.add(fArr);
        
        for(int i=1;i<triangle.length;i++){
            int[] intArr = new int[triangle.length];
            for(int j=0;j<=i;j++){
                if(j>0&&j<i){
                    intArr[j] = Math.max(dp.get(i-1)[j-1], dp.get(i-1)[j]) + triangle[i][j];
                }
                else{
                    if(j==i){
                        intArr[j] = dp.get(i-1)[j-1] + triangle[i][j];
                    }
                    else{
                        intArr[j] = dp.get(i-1)[j] + triangle[i][j];
                    }
                    
                }
            }
            dp.add(intArr);
        }
        
        int max = 0;
        for(int sum : dp.get(dp.size()-1)){
            if(max<sum){
                max = sum;
            }
        }
        
        return max;
    }
}