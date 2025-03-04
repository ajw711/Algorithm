import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static boolean [] visited;

    static int [] check;
    static int N, M;

    static void dfs(int node){
        visited[node] = true;
        for(int num : list.get(node)){
            if(!visited[num]){
                check[num] +=1;
                dfs(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[N+1];
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(A).add(B);
        }
        int max_value = 0;
        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            dfs(i);
        }

        for(int i=1; i<=N; i++){
            if( max_value < check[i]){
                max_value = check[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if( max_value == check[i]){
                sb.append(i + " ");

            }
        }
        System.out.println(sb.toString());


    }



}