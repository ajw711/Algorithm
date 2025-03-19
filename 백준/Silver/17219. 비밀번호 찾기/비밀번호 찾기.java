import java.util.*;
import java.io.*;


public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  
  public static void main(String[] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    Map<String, String> map = new HashMap<String, String>();
    String [] s = new String[M];
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      String key = st.nextToken();
      String value = st.nextToken();
      map.put(key, value);
    }

    for(int i=0; i<M; i++){
      s[i] = br.readLine();
    }

    for(String key : s){
      System.out.println(map.get(key));
    }
    
  }
}