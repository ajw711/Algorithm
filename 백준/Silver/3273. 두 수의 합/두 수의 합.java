import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, X;
    static int [] arr;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);


        int start = 0;
        int end = N-1;
        int cnt = 0;
        int sum = 0 ;


        // 처음에 값을 더해서 초기화
        // 값이 타켓보다 크면

        while(start<end){
            sum = arr[start]+arr[end];

            if(sum == X){
                cnt +=1;
                start+=1;
            }else if(sum>X){
                end -=1;
            }else{
                start+=1;
            }
        }

        System.out.println(cnt);

    }
}