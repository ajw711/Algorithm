  // import static org.junit.jupiter.api.Assertions.assertEquals;
  
  // import org.junit.jupiter.api.Test;
  import java.util.*;
  import java.io.*;

  
  public class Main {
  
    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int arr[];


    static long binarySearch(long start, long end, int target){

      long rs = 0;

      while (start<= end){
         long mid = (start + end )/2;
         long sum = 0;
         int cnt = 1;

        for(int i =0; i<N; i++){
          if( sum + arr[i] <= mid){
             sum +=arr[i];
          }else{
            cnt+=1;
            sum = arr[i];
          }
        }

        if(cnt > target){
          start = mid +1;
        }else{
          rs = mid;
          end = mid -1;
         }
        
      }
      
      return rs;
        
         
    }


    
    
    public static void main(String[] args) throws IOException {

     StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      arr = new int[N];
      
      st = new StringTokenizer(br.readLine());
      int left = 0;
      int right = 0;
      for(int i = 0; i< N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        left = Math.max(left, arr[i]);
        right +=arr[i];
      }
      System.out.println(binarySearch(left, right, M));
    
      


      

      
    }
  
  
  }