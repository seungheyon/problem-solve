import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]);          
            times[i][1] = toMinutes(book_time[i][1]) + 10;    
        }

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] t : times) {
            int start = t[0];
            int end = t[1];
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.add(end);
        }
        return pq.size();
    }
    
    private int toMinutes(String s) {
        String[] parts = s.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
}