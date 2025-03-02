import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N, M;

    static int answer = 0;

    static boolean [] visited;

    static void dfs(int start , int depth){

        if (depth == 5 ){
            answer = 1;
            return;
        }

        visited[start] = true;

        for(int i=0; i<list.get(start).size(); i++){
            int next = list.get(start).get(i);
            if(!visited[next]) {
                dfs(next, depth + 1);
                if (answer == 1){
                    return;
                }
            }
        }
        visited[start] = false;
    }


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }

        for(int i=0; i<N; i++){
            dfs(i, 1);
            if(answer == 1){
                break;
            }
        }
        System.out.println(answer);

    }



}