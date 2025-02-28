import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int R, C;
    static char [][] arr;
    static int [] dx ={-1, 1, 0, 0};
    static int [] dy ={0, 0, -1, 1};
    static boolean [][] visited;

    // 일단 이중 for문을 돌려 늑대가 나오면 스타트를 하고 스타트 기준으로 일단 영약 안에 양과 늑대 개수 파악 후
    // 들어가야 할듯
    //영역 안에 양의 개수와 늑대 개수를 파악해서 늑대가 양을 만나면 늑대가 반대로 소멸
    // 근데 여기서 영약안에 양의 개수와 늑대 개수를 어떻게 파악? dfs bfs 둘중에 하나로 파악 가능하기는 한데..

    static int total_v = 0;
    static int total_o = 0;
    static int cnt_v = 1;
    static int cnt_o = 0;
    static void dfs(int start_x, int start_y){

        visited[start_x][start_y] = true;


        for(int i=0; i<4; i++){
            int nx = start_x + dx[i];
            int ny = start_y + dy[i];

            if(0<=nx && nx<R && 0<=ny && ny<C && arr[nx][ny] !='#'){
                if(!visited[nx][ny]) {
                    if(arr[nx][ny] == 'v'){
                        cnt_v +=1;
                    }else if(arr[nx][ny] == 'o'){
                        cnt_o +=1;
                    }
                    dfs(nx, ny);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'v'){
                    total_v +=1;
                } else if (arr[i][j] == 'o') {
                    total_o +=1;
                }
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'v'){
                    dfs(i, j);
                    if(cnt_o>cnt_v){
                        total_v -= cnt_v;
                    }else{
                        total_o -= cnt_o;
                    }
                    cnt_o = 0;
                    cnt_v = 1;
                }
            }
        }
        System.out.println(total_o + " " + total_v);




    }



}