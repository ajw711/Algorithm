import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        for(int i=score.length - m ; i>=0; i-=m){
            int minValue = score[i];
            answer += minValue * m;
        }
        return answer;
    }
}