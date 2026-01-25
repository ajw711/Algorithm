class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int maxTime = attacks[attacks.length-1][0];
        int index = 0; //attacks index
        int seq = 0; // 연속성
        
        for(int i=1; i<=maxTime; i++){
            
            //공격 시간
            if(index <attacks.length && attacks[index][0] == i){
                answer -= attacks[index][1];
                index++;
                seq = 0;
                
                if(answer <= 0) return -1;
            }else{ // 회복시간
                seq++;
                answer = Math.min(health, answer+bandage[1]);
                
                if(seq == bandage[0]){
                    answer = Math.min(health, answer+bandage[2]);
                    seq = 0;
                }
                
            }
        }
        
        return answer;
        
        
    }
}