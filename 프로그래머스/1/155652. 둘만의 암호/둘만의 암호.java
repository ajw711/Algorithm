import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        

        
        for(char c : s.toCharArray()){
            char newChar = c;
            int cnt = index;
            while(cnt>0){
                newChar++;
                if(newChar > 'z'){
                    newChar = 'a';
                }
                
                if(!skip.contains(String.valueOf(newChar))){
                    cnt--;
                }

             }
            answer+=newChar;
        }

        
        return answer;
    }
}