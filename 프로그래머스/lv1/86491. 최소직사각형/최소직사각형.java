class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;

        for(int i=0;i<sizes.length;i++){
            int size_max = Math.max(sizes[i][0], sizes[i][1]);
            int size_min = Math.min(sizes[i][0], sizes[i][1]);

            if(max<size_max){
                max = size_max;
            }
            if(min<size_min){
                min = size_min;
            }
        }

        answer = max*min;
        return answer;
    }
}