import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int [][] arr = new int[5][5];

    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    static Set<String> set = new HashSet<>();
    static int [] arr2;
    static boolean [] visited;

    static void dfs(int start_x, int start_y, String s){

        if (s.length() == 6){
            set.add(s);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = start_x + dx[i];
            int ny = start_y + dy[i];

            if(0<=nx && nx<5 && 0<=ny && ny<5){
                String num = String.valueOf(arr[nx][ny]);
                dfs(nx, ny, num+s);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i, j, "");
            }
        }
        System.out.println(set.size());



    }



}