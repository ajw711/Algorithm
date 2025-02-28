import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, K;
    static char [][] arr;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1,};
    static boolean [][] visited;

    static int result = 0;
    static void dfs(int start_x, int start_y, int cnt){

        if(start_x == 0 && start_y == C-1 && cnt == K){
            result +=1;
            return;
        }

        for(int i=0; i<4; i++){
            int nx = start_x + dx[i];
            int ny = start_y + dy[i];
            if(0<=nx && nx<R && 0<=ny && ny<C && arr[nx][ny] == '.' && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                visited[nx][ny] = false;
            }
        }
    }




    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.println(result);

    }



}