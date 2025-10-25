import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
    while (storey > 0) {
            int digit = storey % 10;
            if (digit > 5) {
                answer += 10 - digit;  
                storey += 10;        
            } else if (digit == 5) {
                int nextDigit = (storey / 10) % 10;
                if (nextDigit >= 5) { 
                    answer += 10 - digit;
                    storey += 10;
                } else {
                    answer += digit;  
                }
            } else {
                answer += digit;     
            }

            storey /= 10;
        }

        return answer;
    }
}