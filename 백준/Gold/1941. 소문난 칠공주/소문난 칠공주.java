import java.util.*;
import java.io.*;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [][] arr;
    static int cnt = 0;
    static ArrayDeque<Node> rs = new ArrayDeque<>();
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static boolean[] visited = new boolean[25];

    static boolean bfs(){

        ArrayDeque<Node> dp = new ArrayDeque<>();
        boolean [][] visitedBfs = new boolean[5][5];
        Node start = rs.peekFirst();
        dp.add(start);
        visitedBfs[start.getX()][start.getY()] = true;
        // 연결 노드 개수
        int checkCount = 1;


        while(!dp.isEmpty()){
            Node p = dp.pop();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if( 0<= nx && nx<5 && 0<= ny && ny<5 ){
                    // rs에 포함되어 있는 노드인지 확인
                    int flag = 0;
                    for(Node n : rs){
                        if(n.getX() == nx && n.getY() == ny){
                            flag = 1;
                            break;
                        }
                    }

                    if(flag == 1 && !visitedBfs[nx][ny]){
                        visitedBfs[nx][ny] = true;
                        dp.add(new Node(nx, ny));
                        checkCount++;
                    }
                }
            }
        }
        return checkCount == 7;
    }

    static boolean sCount(){
        int s_count = 0;
        for (Node p : rs) {
            if (arr[p.getX()][p.getY()] == 'S'){
                s_count++;
            }
        }
        return s_count > 3;
    }

    static void combination(int depth, int startIdx){
        if(depth == 7){
            //bfs로 인접 체크
            //S가 4개 이상인지 체크
            if(bfs() && sCount()){
                cnt++;
            }
            return;
        }
        for(int i= startIdx; i<25; i++){
            int x = i / 5;
            int y = i % 5;
            if(!visited[i]){
                visited[i] = true;
                rs.add(new Node(x, y));
                combination(depth+1, i);
                rs.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        arr = new char[5][5];
        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<5; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        combination(0, 0);
        System.out.println(cnt);
    }
}
