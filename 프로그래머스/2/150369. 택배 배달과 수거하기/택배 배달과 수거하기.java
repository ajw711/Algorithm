class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dliver = 0;
        int pick = 0;
        for(int i=n-1; i>=0; i--){
            dliver += deliveries[i];
            pick += pickups[i];
            
            while(dliver > 0 || pick > 0) {
                dliver -= cap;
                pick -= cap;
                answer += (i+1) * 2;
            }
        }
        return answer;
    }
}


