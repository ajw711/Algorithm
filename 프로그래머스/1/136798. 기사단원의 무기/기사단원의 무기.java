import java.util.*;

class Solution {
    
    static int find(int N){
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        
        for(int i=1; i*i<=N; i++){
            if(N % i == 0){
                list.add(i);
                cnt++;
                if( i != N/i){
                    list.add(N/i);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
           int targetCnt = find(i);
            if(targetCnt > limit){
                answer += power;
            }else{
                answer += targetCnt;
            }
        }
        return answer;
    }
}