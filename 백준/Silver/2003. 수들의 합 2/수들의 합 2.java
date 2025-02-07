import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr;


    public static void main(String[] args) throws IOException {

        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int sum = arr[start];
        int cnt = 0;

        // 합이 M 보다 크면 start ++ 해준다.
        // 합이 M 보다 작으면 end ++ 해준다.
        // 합이 M이랑 같으면 cnt +1해준다.

        while(end<=N){

            if(sum == M){
                cnt +=1;
                sum -= arr[start];
                start +=1;
            }else if(sum >M){
                sum -= arr[start];
                start +=1;
            }else{
                sum +=arr[end];
                end+=1;
            }
        }

        System.out.println(cnt);

    }
}