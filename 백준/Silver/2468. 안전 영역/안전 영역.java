import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;

    }
}



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max_value;




    static void bfs(int start_x, int start_y, int height, boolean[][] visited){

         ArrayDeque<Node> p = new ArrayDeque<>();
         p.add(new Node(start_x, start_y));
         visited[start_x][start_y] = true;
         while( !p.isEmpty()){
             Node cur = p.poll();
             int cx = cur.getX();
             int cy = cur.getY();

             for(int i=0; i<4; i++){
                 int nx = cx + dx[i];
                 int ny = cy + dy[i];
                 if(0<= nx && nx<N && 0<= ny && ny<N){
                     if(arr[nx][ny] > height && !visited[nx][ny]){
                         p.add(new Node(nx, ny));
                         visited[nx][ny] = true;
                     }
                 }

             }


         }
    }






    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];



        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max_value = Math.max(max_value, arr[i][j]);
            }
        }

        int rs = 0;

        for(int height=0; height<=max_value; height++){
            boolean[][] visited = new boolean[N][N];
            int cnt = 0;

            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    if(!visited[x][y] && arr[x][y]>height){
                        bfs(x, y, height, visited);
                        cnt+=1;
                    }
                }
            }
            rs = Math.max(cnt, rs);
        }
        System.out.println(rs);





    }
}