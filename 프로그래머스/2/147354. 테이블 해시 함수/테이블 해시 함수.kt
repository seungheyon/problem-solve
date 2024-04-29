class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0
        data.sortWith(compareBy({ it[col-1] }, { -it[0] }))
        for(i in row_begin-1 until  row_end){
            var modsum = 0
            for(value in data[i]){
                modsum += value%(i+1)
            }
            answer = answer xor modsum 
        }
        return answer
    }
}