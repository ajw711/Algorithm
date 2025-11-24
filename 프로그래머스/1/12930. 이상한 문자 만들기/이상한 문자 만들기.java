import java.util.*;

class Solution {
    public String solution(String s) {
        String[] s1 = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for(String target : s1){
            for(int i=0; i<target.length(); i++){
                if( i%2 == 0 ){
                    sb.append(Character.toUpperCase(target.charAt(i)));
                }else{
                    sb.append(Character.toLowerCase(target.charAt(i)));
                }
            }
            sb.append(" ");
        }
         return sb.substring(0, sb.length() - 1);
    }
}