import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] arr;


    static int rLeft, rRight;
    static Long sum = Long.MAX_VALUE;





    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;

        Arrays.sort(arr);

        while(start< end){
             long sum2 = arr[start] + arr[end];

            if(Math.abs(sum) > Math.abs(sum2)){
                sum = sum2;
                rLeft = arr[start];
                rRight = arr[end];
            }

            if(sum2 <= 0){
                start +=1;
            }else{
                end -=1;
            }
        }

        System.out.println(rLeft+" "+rRight);

    }
}