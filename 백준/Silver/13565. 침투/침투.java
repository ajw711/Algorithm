import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M, N;
    static int [][] arr;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static boolean [][] visited;
    static boolean flag = false;
    static void dfs(int start_x, int start_y){

        if(start_x == M-1){
            flag = true;
            return;
        }
        visited[start_x][start_y] = true;

        for(int i=0; i<4; i++){
            int nx = start_x + dx[i];
            int ny = start_y + dy[i];
            if(0<= nx && nx<M && 0<= ny && ny<N && arr[nx][ny] == 0 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i=0; i<N; i++){
            if(arr[0][i] == 1){
                continue;
            }

            if(flag){
                break;
            }else{
                dfs(0, i);
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }



}