class Solution {
    
    private void dfs(int depth, int[] numbers, int sum, int target){
        
        if(depth == numbers.length){
            if(sum == target) cnt++;
            return;
        }
        int[] select = {-1, 1};
        for(int i=0; i<2; i++){
            int next = sum + (numbers[depth] * select[i]);
            dfs(depth+1, numbers, next, target);
        }
    }
    
    static int cnt;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        cnt = 0;
        dfs(0, numbers, 0, target);
        return cnt;
    }
}