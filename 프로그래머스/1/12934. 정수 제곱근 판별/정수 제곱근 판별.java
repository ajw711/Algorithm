import java.util.*;
class Solution {
    
 
    public boolean isInteger(double num){
        return num % 1 == 0.0;
    }
    
    public long solution(long n) {
        long answer = 0;
        
        if(isInteger(Math.sqrt(n))) {
            
            answer = (long) Math.pow(Math.sqrt(n)+1,2);
        }else{
            answer = -1;
        }
           
    return answer;
  }
}