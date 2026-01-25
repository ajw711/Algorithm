class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        String target = board[h][w];
        
        
        for(int i=0; i<4; i++){
            int nx = w+dx[i];
            int ny = h+dy[i];
            if(nx >= 0 && nx<board[0].length && ny >=0 && ny < board.length){
                if(board[ny][nx].equals(target)){
                    answer++;
                }
            }
        }
        return answer;
    }
}