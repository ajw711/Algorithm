
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(maxHeap.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(maxHeap.poll());
                }
            }else{
                maxHeap.offer(num);
            }

        }

    }


}