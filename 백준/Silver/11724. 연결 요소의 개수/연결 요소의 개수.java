import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    private static void dfs(int node){

        if(visited[node]){
            return;
        }

        visited[node] = true;
        for(int num : list.get(node)){
            if(!visited[num]){
                dfs(num);
            }
        }

    }



    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]){
                continue;
            }
            dfs(i);
            cnt+=1;
        }

        System.out.println(cnt);

    }
}