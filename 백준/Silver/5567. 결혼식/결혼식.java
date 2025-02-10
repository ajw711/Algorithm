import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static boolean[] visited;

    static void dfs(int start, int cnt){

       if(cnt == 2){
           return;
       }

        for(int num : list.get(start)){
                visited[num] = true;
                dfs(num, cnt + 1);
        }
    }


    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1, 0);
        int rs = 0;
        for(int i=2; i<=N; i++){
            if(visited[i]) rs+=1;
        }
        System.out.println(rs);

    }
}