import java.util.*;
class Solution {
    
    static class Node{
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    private int bfs(int[][] map, int startX, int startY, int targetX, int targetY){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(startX, startY, 0));
        
        boolean[][] visited = new boolean[102][102];
        visited[startY][startX] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!dp.isEmpty()){
            Node cur = dp.poll();
            
            // 타켓 발견
            if(cur.x == targetX && cur.y == targetY){
                return cur.dist / 2;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102){
                    if (!visited[ny][nx] && map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        dp.add(new Node(nx, ny, cur.dist+1));
                    }
                }
            }
        }
        return -1;
        
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[102][102];
        
        //직사각형 그리기
        for(int[] rect : rectangle){
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for(int i=y1; i<=y2; i++){
                for(int j=x1; j<=x2; j++){
                    // 현재 위치가 직사각형 내부라면
                    if(i>y1 && i<y2 && j>x1 && j<x2){
                        map[i][j] = 2;
                    }else if(map[i][j] !=2){
                        map[i][j] = 1; // 테두리이고 다른 사각형 내부가 아닌 경우
                    }
                }
            }
        }
        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
}