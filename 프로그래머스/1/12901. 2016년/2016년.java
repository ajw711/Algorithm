import java.util.*;
import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        String[] answer = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        LocalDate localDate = LocalDate.of(2016, a, b);
        int day = localDate.getDayOfWeek().getValue();
        return answer[day%7];
    }
}