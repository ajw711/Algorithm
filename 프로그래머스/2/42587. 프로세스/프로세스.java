import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // index 
        Deque<Integer> dp = new ArrayDeque<>();

        for(int i=0; i<priorities.length; i++){
            dp.add(i);
        }
        
        while(!dp.isEmpty()){
            int cur = dp.poll(); // 현재 프로세스 index
            int curPrior = priorities[cur]; // 현재 프로세스 우선순위
            
            boolean check = false;
            // 큐안에 더 높은 우선순위 확인
            for(int idx : dp){
                if(priorities[idx] > curPrior) {
                    check = true;
                    break;
                }
            }
            
            if(check){
                //큐에 넣기
                dp.add(cur);
            }else{
                answer++;
                
                if(location == cur){
                    return answer;
                }
            }
            
        }

        return answer;
    }
}