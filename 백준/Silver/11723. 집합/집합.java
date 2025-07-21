import java.util.*;
import java.io.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if(!cmd.equals("all") && !cmd.equals("empty")){
                x = Integer.parseInt(st.nextToken());
            }

            switch(cmd) {
                case "add":
                    arr.add(x);
                    break;
                case "remove":
                    arr.remove(Integer.valueOf(x));
                    break;
                case "check":
                    sb.append(arr.contains(x) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    if(arr.contains(x)) {
                        arr.remove(Integer.valueOf(x));
                    } else {
                        arr.add(x);
                    }
                    break;
                case "all":
                    arr.clear();
                    for(int j=1; j<=20; j++) {
                        arr.add(j);
                    }
                    break;
                case "empty":
                    arr.clear();
            }
        }
        System.out.print(sb.toString());
    }

}