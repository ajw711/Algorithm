import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int [][] adj; // 인접행렬

    static boolean [][] visited; //방문행렬
    static int[] dx = {0, 0, -1, 1}; // 좌우상하
    static int[] dy = {-1, 1, 0, 0};

    static int count ;

    static int T; //테스트 케이스 개수
    static int N,M; //세로 ,가로 길이
    static int K; // 배추 심은곳 개수


    static void dfs(int start_x, int start_y){
        visited[start_x][start_y] = true;

        for (int i=0; i<4; i++){
            int cx = start_x + dx[i];
            int cy = start_y + dy[i];

            if (0<= cx && cx<M && 0<=cy && cy<N ){
                if (!visited[cx][cy] && adj[cx][cy] == 1){
                    dfs(cx, cy);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {


        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            adj = new int[M][N];
            visited = new boolean[M][N];

            for (int j=0; j<K; j++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st1.nextToken());
                int end = Integer.parseInt(st1.nextToken());

                adj[start][end] = 1;

            }

            count = 0;

            for (int x=0; x<M; x++){
                for (int y=0; y<N; y++){
                    if (adj[x][y] == 1 && !visited[x][y]){
                        dfs(x,y);
                        count +=1;
                    }
                }
            }
            System.out.println(count);

        }


    }
}