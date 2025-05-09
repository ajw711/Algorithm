import java.util.*;
import java.io.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] arr;
    static ArrayDeque<Integer> dp = new ArrayDeque<>();
    static boolean [] visited;
    static int N;
    static int max_count = -1;



    static void permuation(int depth){

        if(depth == N){

            int count =0;
            for(int i=0; i<N; i++){
                if(arr[i][0] < 1){
                    count++;
                }
            }
            max_count = Math.max(max_count, count);
            return;
        }
        if(arr[depth][0] < 1){
            permuation(depth+1);
            return;
        }
        // 계란 치기 가능 여부
        boolean flag = false;
        for(int i= 0; i<N; i++){
            if(i == depth || arr[i][0] < 1){
                continue;
            }

            // 내구도 감소
            arr[depth][0] -= arr[i][1];
            arr[i][0] -= arr[depth][1];
            flag = true;

            permuation(depth+1);

            // 내구도 복원
            arr[depth][0] += arr[i][1];
            arr[i][0] += arr[depth][1];
        }
        if(!flag){
            permuation(depth+1);
        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        visited = new boolean[N];



            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            permuation(0);
            System.out.println(max_count);
                
    }
}
