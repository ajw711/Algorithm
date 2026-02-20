import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> dp = new ArrayDeque<>();
        for(char c : number.toCharArray()){
            while(!dp.isEmpty () && k > 0 && dp.peekLast() < c){
                dp.pollLast();
                k--;
            }
            dp.offerLast(c);
        }
        while(k > 0){
            dp.pollLast();
            k--;
        }
        for(char c : dp){
            sb.append(c);
        }
        
        return sb.toString();
    }
}