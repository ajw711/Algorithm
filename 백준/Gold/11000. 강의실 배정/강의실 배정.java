import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); 
            arr[i][1] = Integer.parseInt(st.nextToken()); 
        }

        // 시작 시간 기준으로 정렬
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        pq.add(arr[0][1]);

        for(int i=1; i<n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(pq.peek() <= start){
                pq.poll();
            }
            pq.add(end);
        }

        System.out.println(pq.size());
        
    }
}