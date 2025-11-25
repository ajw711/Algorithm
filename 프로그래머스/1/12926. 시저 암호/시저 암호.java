import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(' ');
            }
            
            if('A' <= c && c <= 'Z'){
                char next = (char)(( c- 'A' + n) % 26 + 'A');
                sb.append(next);
            }
            
            if('a' <= c && c <= 'z'){
                char next = (char)(( c- 'a' + n) % 26 + 'a');
                sb.append(next);
            }
        }
        return sb.toString();
    }
}
