import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, C;
    static int [] arr;

    static long binarySearch(long start, long end){
        long rs =0;
        while (start<=end){

            long mid = (start+end) / 2;
            long cnt = 1;
            long install = arr[0];


            for (int i=1; i<N; i++){
                if( arr[i] >= install+mid){
                    cnt+=1;
                    install = arr[i];
                }
            }
            if (cnt>=C){
                rs = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }

        }
        return rs;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(0,arr[N-1]));

    }
}