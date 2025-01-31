import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;


class Node{
    private int x;
    private int y;

    public Node(int x, int  y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }


}



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   static int N;
   static int [][] board;

   static int line ;

   static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
   static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

   static int bfs(int start_x, int start_y, int end_x, int end_y){
       ArrayDeque<Node> dp = new ArrayDeque<>();
       dp.add(new Node(start_x,start_y));


       while(!dp.isEmpty()){
           Node p = dp.poll();
           int cx = p.getX();
           int cy = p.getY();

           if(end_x == cx && end_y == cy){
                return board[cx][cy];

           }


           for(int i=0; i<8; i++){
               int nx = cx + dx[i];
               int ny = cy + dy[i];
                if(0<=nx && nx<line && 0<=ny && ny<line && board[nx][ny] ==0){
                    dp.add(new Node(nx,ny));
                    board[nx][ny] = board[cx][cy]+1;
                }
           }
       }

       return  0;

   }


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());




        for(int i=0; i<N; i++){
            line = Integer.parseInt(br.readLine());

            board = new int[line][line];

            for(int x=0; x<line; x++){
                for(int y=0; y<line; y++){
                    board[x][y] = 0;
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            int cnt = bfs(start_x, start_y, end_x, end_y);

            System.out.println(cnt);
        }


    }
}