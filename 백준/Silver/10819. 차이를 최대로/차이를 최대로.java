import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int [] arr;
    static ArrayList<Integer> list = new ArrayList<>();

    static boolean [] visited;

    static int max_value = (int) -1e9;


    static void dfs(int depth){

        if(depth == N){
            int sum = 0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(list.get(i) - list.get(i+1));
            }
            max_value =Math.max(max_value,sum);
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            list.add(arr[i]);
            dfs(depth+1);
            visited[i] = false;
            list.remove(list.size()-1);
        }


    }


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            visited[i] = false;
        }

        dfs(0);
        System.out.println(max_value);




    }
}