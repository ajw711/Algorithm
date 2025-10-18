class Solution {
    
    static boolean win(String[] board, char type){
        
        for(int i=0; i<3; i++){
            if(board[i].charAt(0) == type && board[i].charAt(1) == type && board[i].charAt(2) == type ){
                return true;
            }
             if(board[0].charAt(i) == type && board[1].charAt(i) == type && board[2].charAt(i) == type ){
                return true;
            }
        }
        
        //대각선
        
        if(board[0].charAt(0) == type && board[1].charAt(1) == type && board[2].charAt(2) == type ){
            return true;
        }
        if(board[0].charAt(2) == type && board[1].charAt(1) == type && board[2].charAt(0) == type ){
            return true;
        }
        
        return false;
    }
    
    public int solution(String[] board) {
        int answer = 1;
        int countO = 0;
        int countX = 0;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                char c = board[i].charAt(j);
                if (c == 'O') countO++;
                if (c == 'X') countX++;
            }
        }

 
        if (countO < countX || countO > countX + 1) return 0; 
        
        boolean O = win(board, 'O');
        boolean X = win(board, 'X');
        
        if(O && X) return 0;
        

        if (O && countO != countX + 1) return 0;
        if (X && countO != countX) return 0;

        
        return answer;
    }
}
