import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb1 = new StringBuilder();

        for(int i=1; i<food.length; i++){
            if(food[i] == 1){
                continue;
            }
            for(int j=0; j<food[i]/2; j++){
                sb1.append(i);
            }
        }
      StringBuilder sb2 = new StringBuilder(sb1.toString());
        sb2.reverse();
        sb1.append(0);
        sb1.append(sb2);
        
        return sb1.toString();
    }
}