import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int T, N, M;
    static int [] arr;
    static int binarySearch(int target){

        int start = 0, end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return 1;
            if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int target = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(target)).append("\n");
            }

        }
        System.out.print(sb);

    }
}