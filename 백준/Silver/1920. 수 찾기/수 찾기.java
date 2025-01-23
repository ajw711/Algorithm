import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;





public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    static int[] A;
    static int[] B;

    static int binarySearch(int[] arr, int start, int end, int target){
        while (start <= end){
            int mid = (start+end) /2;
            if (arr[mid] == target){
                return 1;
            }
            else if (arr[mid] > target){
                end = mid-1;
            }
            else {
                start = mid+1;
            }

        }
        return 0;
    }


    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }


        for (int i=0; i<M; i++){
            System.out.println(binarySearch(A, 0, N-1, B[i] ));
        }


    }
}