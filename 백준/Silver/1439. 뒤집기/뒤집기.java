import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s;


    public static void main(String[] args) throws IOException {

        s = br.readLine();
        int cnt0 = 0;
        int cnt1 = 0;
        if (s.charAt(0) == '0') {
            cnt0+=1;
        }
        else {
            cnt1 += 1;
        }

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                if(s.charAt(i) == '0'){
                    cnt0+=1;
                }else{
                    cnt1 +=1;
                }
            }
        }
        System.out.println(Math.min(cnt0, cnt1));


    }



}