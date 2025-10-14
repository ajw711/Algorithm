class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++){
            int target = n-1;
            if( target%i == 0){
                answer = i;
                break;
            }
        }
        return answer;
    }
}