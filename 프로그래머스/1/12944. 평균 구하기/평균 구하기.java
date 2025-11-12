import java.util.*;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        OptionalDouble average = Arrays.stream(arr).average();
        answer = average.orElse(0);
        return answer;
    }
}