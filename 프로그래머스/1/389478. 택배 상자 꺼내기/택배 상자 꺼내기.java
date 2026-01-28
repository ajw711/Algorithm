import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        //2차원 배열로 만들고 없으면 0으로 채우고
        int h = (int) Math.ceil((double)n/w);
        int[][] arr =new int[h][w];
        int cnt = 1;
        int index_x = -1;
        int index_y = -1;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(cnt <= n){
                    if(i % 2 == 0){
                        arr[i][j] = cnt;            
                    }else{
                        arr[i][w-j-1] = cnt;
                    }

                    if(cnt == num){
                        index_y = i;
                        if( i % 2 == 0){
                            index_x = j;
                        }else{
                            index_x = w - j - 1;
                        }
                    }
                    cnt++;
                    }
            }
        }
        
        for(int i=index_y; i<h; i++){
            if(arr[i][index_x] != 0 && arr[i][index_x] <= n) answer++; 
        }
        return answer;
    }
}