import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N, M;
    static int[] arr;

    static int binarySearch(int target) {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 1. N 입력 및 배열 초기화
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            // 2. 배열 입력 및 정렬
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            // 3. M 입력 및 탐색
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int target = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(target)).append("\n");
            }
        }

        // 최적화된 출력 (한 번에 출력)
        System.out.print(sb);
    }
}
