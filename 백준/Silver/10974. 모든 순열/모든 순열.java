import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr;

    static boolean[] visited;

    static ArrayDeque<Integer> dp = new ArrayDeque<>();

    static void dfs(int depth){

        if (depth == N){
            for(Integer num : dp){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]){
                continue;
            }
            dp.add(i);
            visited[i] = true;
            dfs(depth+1);
            dp.pollLast();
            visited[i] = false;
        }

    }


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        Arrays.fill(visited, false);
        dfs(0);
        System.out.println(sb);
    }
}