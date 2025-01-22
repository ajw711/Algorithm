import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adj; // 2차원 인접리스트

    static boolean[] visited_dfs;

    static boolean[] visited_bfs;
    static int N, M, V;



    static void dfs(int start){

        visited_dfs[start] = true;
        System.out.print(start+" ");

        for(int node=1; node<=N; node++){
            if(!visited_dfs[node] && adj[start][node] == 1){
               dfs(node);
            }

        }
    }

    static void bfs(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited_bfs[start] = true;


        while (!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for (int nextNode = 1; nextNode <=N; nextNode++){
                if (adj[node][nextNode] == 1 && !visited_bfs[nextNode]){
                    q.add(nextNode);
                    visited_bfs[nextNode] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited_dfs = new boolean[N+1];
        visited_bfs = new boolean[N+1];

        adj = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());
            adj[start][end] = adj[end][start] = 1;

        }


        dfs(V);
        System.out.println();
        bfs(V);
    }
}