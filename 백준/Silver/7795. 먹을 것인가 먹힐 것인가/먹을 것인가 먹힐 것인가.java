import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N, M;
    static int [] A;
    static int [] B;

    static int cnt;

    static int binarySearch(int target, int end){
        cnt = 0;
        int start = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            if(target > B[mid]){
                cnt = mid+1;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<M; k++){
                B[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int answer = 0;

            for(int num=0; num<N; num++){
                answer = answer + binarySearch(A[num],M-1);
            }
            System.out.println(answer);


        }





    }
}