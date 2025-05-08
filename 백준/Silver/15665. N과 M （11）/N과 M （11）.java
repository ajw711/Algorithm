import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static Integer [] arr;
    static ArrayDeque<Integer> list = new ArrayDeque<>();
    static TreeSet<Integer> set  = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs(int node){

        if(node == M){
            for(Integer i : list){
               sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (Integer i : arr){
            list.add(i);
            dfs(node+1);
            list.removeLast();
        }

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        arr = set.toArray(new Integer[0]);
        dfs(0);
        System.out.println(sb);


    }
}
