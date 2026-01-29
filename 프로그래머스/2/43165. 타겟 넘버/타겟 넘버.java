class Solution {
    static int cnt;
    static int[] op = {1, -1};
    
    static void dfs(int depth, int sum, int[] numbers, int target){
        
        if(depth == numbers.length){
            if(sum == target) cnt++;
            return;
        }
        
        for(int i=0; i<op.length; i++){
            int nextSum = sum + (numbers[depth] * op[i]);
            dfs(depth+1, nextSum, numbers, target);
        }
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        cnt = 0;
        dfs(0, 0, numbers, target);
        return cnt;
    }
}