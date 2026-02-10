class Solution {
    int n;
    int cnt = 0;
    
    boolean[] cols; // 세로체크
    boolean[] diag1; // 우하양 대각선 체크
    boolean[] diag2; // 좌하양 대각선 체크
    
    private void dfs(int row){
        //마지막 row 돌면 끝
        if(row == n){
            cnt++;
            return;
        }
        
        for(int col = 0; col<n; col++){
            // 각 길의 인덱스 계산
            int d1 = row - col + (n - 1);
            int d2 = row + col;
            
            // 이미 있는지 체크
            if(cols[col] || diag1[d1] || diag2[d2]){
                continue;
            }
            
            // 퀸놓기
            cols[col] = diag1[d1] = diag2[d2] = true;
            
            dfs(row+1);
            
            // 다시 되돌아와서 되돌리기
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
    
    public int solution(int n) {
        this.n = n;
        this.cols = new boolean[n];
        this.diag1 = new boolean[2 * n - 1]; // 4일 때 7개
        this.diag2 = new boolean[2 * n - 1]; // 4일 때 7개
        
        dfs(0);
        return cnt;
    }
}