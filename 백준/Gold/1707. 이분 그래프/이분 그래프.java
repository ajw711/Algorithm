import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list;
    static boolean [] visited;

    static int [] check;
    static boolean flag;
    static int K, V, E;

    static void dfs(int node){
        visited[node] = true;

        for(int num : list.get(node)){
            if(!visited[num]) {
                check[num] = (check[node] + 1) % 2; //집합을 0집합과 1집합으로 분류
                dfs(num);
            }else{
                if(check[node] == check[num]){
                    flag = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {


        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            visited = new boolean[V+1];
            check = new int[V+1];
            flag = true;

            for(int j=0; j<=V; j++){
                list.add(new ArrayList<>());
            }

            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(start).add(end);
                list.get(end).add(start);
            }

            for(int j=1; j<=V; j++){
                if(flag){
                    dfs(j);
                }else{
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }



}