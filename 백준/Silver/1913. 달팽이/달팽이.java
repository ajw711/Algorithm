
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] snail;
    //하 우 상 좌
    static int [] dr = {1,0,-1,0};
    static int [] dc = {0,1,0,-1};
    static int r ,c =0;
    static int dir =0;

    static int [] target = {0,0};

    static StringBuilder sb = new StringBuilder();

    static void print(int [][] array, int k){


        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                sb.append(array[i][j] + " ");
                if(array[i][j]==k){
                    target[0]=i+1;
                    target[1]=j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(target[0]+" "+target[1]);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {

        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());



        snail=new int[n][n];

        for(int i = n*n; i>0; i--){

            snail[r][c] = i;

            int nr= r + dr[dir];
            int nc= c + dc[dir];


            if(nr > n-1 || nr < 0 || nc < 0 || nc > n-1 || snail[nr][nc] !=0){
                dir =  (dir+1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r=nr;
            c=nc;
        }
        print(snail,k);


    }
}