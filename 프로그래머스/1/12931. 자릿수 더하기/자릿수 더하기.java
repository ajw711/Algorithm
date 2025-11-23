import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] s = String.valueOf(n).split("");
        for(String num : s){
            answer += Integer.parseInt(num);
        }

        return answer;
    }
}