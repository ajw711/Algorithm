import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x= x;
        this.y= y;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }
}


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, K;

    static int [] dx = {-1, 1 , 0, 0};
    static int [] dy = {0, 0 , -1, 1};
    static int [][] arr;
    static boolean [][] visited;
    static int max_value = Integer.MIN_VALUE;

    static void bfs(int x, int y){
        ArrayDeque<Node> dp = new ArrayDeque<>();
        visited[x][y] = true;
        dp.add(new Node(x,y));
        int cnt =1;

        while(!dp.isEmpty()){
            Node p = dp.poll();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dp.add(new Node(nx, ny));
                    cnt+=1;
                }
            }
        }
        max_value = Math.max(cnt, max_value);

    }

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            arr[X-1][Y-1] = 1;
        }
   

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && arr[i][j] == 1 ){
                    bfs(i,j);
                }
            }
        }
        System.out.println(max_value);




    }
}