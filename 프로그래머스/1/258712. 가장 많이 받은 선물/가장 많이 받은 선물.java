import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;

        HashMap<String ,Integer> index = new HashMap<>();
        for(int i=0; i<len; i++){
            index.put(friends[i], i);
        }
        int[][] gift = new int[len][len];
        
     
        for(String s: gifts){
            String[] target = s.split(" ");
            int from = index.get(target[0]);
            int to = index.get(target[1]);
            gift[from][to]++;
        }
        
        int[] giftScore = new int[len];
        for(int i=0; i<len; i++){
            int give = 0;
            int receive = 0;
            for(int j=0; j<len; j++){
                give += gift[i][j];
                receive += gift[j][i];
            }
            giftScore[i] = give - receive;
        }
        
        int[] next = new int[len];
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                if(gift[i][j] > gift[j][i]){
                    next[i]++;
                }else if(gift[i][j] < gift[j][i]){
                    next[j]++;
                } else { // 같으면
                    if(giftScore[i] > giftScore[j]) next[i]++;
                    else if(giftScore[i] < giftScore[j]) next[j]++;
                }
            }
        }
        
        for(int i=0; i<len; i++){
            answer = Math.max(answer, next[i]);
        }
        
        return answer;
    }
}