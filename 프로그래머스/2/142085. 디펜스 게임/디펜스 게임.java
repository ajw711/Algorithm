import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int soldier = n;
        for(int i=0; i<enemy.length; i++){
            pq.add(enemy[i]); // 병사를 막는다고 가정
            soldier -= enemy[i]; // 병사 차감
            
            if(soldier < 0){
                //만약에 가정한 병사를 다 사용하면 실드 사용
                if(k > 0){
                    soldier += pq.poll(); // 실드로 병사 살리기
                    k--; //실드 차감
                }else{
                    // 실드 다 소진했고 병사가 없음 게임 오버
                    return i;
                }
            }
        }
        // 만약에 전체 스테이지 클리어하면
        return enemy.length;
    }
}