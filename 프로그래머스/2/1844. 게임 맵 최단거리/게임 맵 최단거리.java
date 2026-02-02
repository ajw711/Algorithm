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
    
    public int bfs(int[][] maps){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(0, 0, 1));
        int targetY = maps.length;
        int targetX = maps[0].length;
        boolean[][] visited = new boolean[targetY][targetX];
        visited[0][0] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!dp.isEmpty()){
            Node cur = dp.poll();
            if(cur.x == targetX-1 && cur.y == targetY-1){
                return cur.dist;
            }
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(0 > nx || targetX-1 < nx || 0 > ny || targetY-1 < ny) continue;
                if(visited[ny][nx] || maps[ny][nx] == 0) continue;
                
                visited[ny][nx] = true;
                dp.add(new Node(nx, ny, cur.dist+1));
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
}