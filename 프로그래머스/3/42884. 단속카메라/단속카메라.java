import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // 진출 지점 기준으로 오름 차순 정렬
        // 진입 시 해당 카메라 보다 크면 나두고
        // 진입 시 카메라가 진입 지점 보다 낮으면
        // 카메라 +1 해주면서 카메라를 해당 진출 지점으로 업데이트

        int camera = Integer.MIN_VALUE;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]); 
        for(int i=0; i<routes.length; i++){
            if(camera<routes[i][0]){
                answer++;
                camera = routes[i][1];
            }
        }
        return answer;
    }
}