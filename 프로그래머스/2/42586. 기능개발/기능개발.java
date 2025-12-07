import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Deque<Integer> dp = new ArrayDeque<>();
        int[] days = new int[progresses.length];
        
        // 배포 일 계산
        for(int i=0; i<progresses.length; i++){
            int day = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            days[i] = day;
        }
        int cur = days[0];
        int count = 1; //첫 배포
        for(int i=1; i<days.length; i++){
            if(cur < days[i]){
                    cur = days[i];
                    dp.add(count);
                    count = 1;
             } else {
                count++;
            }

        }

        // 마지막 배포
        dp.add(count);
        
        int[] answer = new int[dp.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = dp.poll();
        }
        
        return answer;
    }
}