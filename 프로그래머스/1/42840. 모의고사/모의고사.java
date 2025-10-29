import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] cnt = new int[3];
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        ArrayList<Integer> list =  new ArrayList<>();
        int max = -1;
        
        for(int i=0; i<answers.length; i++){
            if(one[i%5] == answers[i]) {
              cnt[0]+=1;   
            }
            if(two[i%8] == answers[i]){
                cnt[1]+=1;
            }
            if(three[i%10] == answers[i]){
                cnt[2]+=1;
            }
        }
        
        for(int i=0; i<3; i++){
            if(cnt[i] > max){
                max = cnt[i];
            }
        } 
        
        for(int i=0; i<3; i++){
            if(max == cnt[i]){
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}