import java.time.DayOfWeek;
import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek day = date.getDayOfWeek();
        answer = day.toString();
        answer = answer.substring(0,3);

        return answer;
    }
}