import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
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
    // 테스트, 편의점의 개수
    static int T, N;
    //  상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표
    static int start_x, start_y;
    static int [][] arr;


    static boolean [] visited ;
    static int rock_x, rock_y;

    static boolean bfs(int start_x, int start_y, int rock_x, int rock_y){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        dp.add(new Node(start_x, start_y));

        while(!dp.isEmpty()){
            Node q = dp.poll();
            int cx = q.getX();
            int cy = q.getY();

            if( Math.abs((cx-rock_x))+Math.abs((cy-rock_y)) <=1000 ){
                return true;
            }

            for(int i=0; i<N; i++){
                if(!visited[i]){
                    int nx = arr[i][0];
                    int ny = arr[i][1];

                    if( Math.abs((cx-nx))+Math.abs((cy-ny)) <=1000 ){
                        visited[i]=true;
                        dp.add(new Node(nx, ny));
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){

         N = Integer.parseInt(br.readLine());
         visited = new boolean[N];
         StringTokenizer st = new StringTokenizer(br.readLine());
         start_x = Integer.parseInt(st.nextToken());
         start_y = Integer.parseInt(st.nextToken());
         arr = new int[N][N];
         for(int j=0; j<N; j++){
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
             arr[j][0] = x;
             arr[j][1] = y;
         }
         st = new StringTokenizer(br.readLine());
         rock_x = Integer.parseInt(st.nextToken());
         rock_y = Integer.parseInt(st.nextToken());
         System.out.println(bfs(start_x, start_y ,rock_x, rock_y) ? "happy" : "sad");
        }

    }



}