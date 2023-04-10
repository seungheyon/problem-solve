class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = 0;
        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                loop : for(int k=j+1;k< nums.length;k++){
                    num = nums[i] + nums[j] + nums[k];
                    System.out.println(i+" "+j+" "+k);
                    for(int l = 2;l<=(int)Math.sqrt(num);l++){
                        if(num%l==0){
                            continue loop;                            
                        }
                    }
                    System.out.println(num);
                    answer ++;
                }
            }
        }
        return answer;
    }
}