import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] s =String.valueOf(n).split("");
        Arrays.sort(s, Collections.reverseOrder());
        String result = String.join("",s);
        answer = Long.parseLong(result);
        return answer;
    }
}