import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
     

        // ext, sort_by 값에 맞는 인덱스 설정
        String[] s = {"code", "date", "maximum", "remain"};
        int ext_index = -1;
        int sort_by_index = -1;
        
        for(int i=0; i<s.length; i++){
            if(s[i].equals(ext)){
                ext_index = i;
            }
            if(s[i].equals(sort_by)){
                sort_by_index = i;
            }
        }
        
        // ext 값에 맞는 추출 값 추출
        // counting 및 data 인덱스 찾기
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            if(data[i][ext_index] < val_ext){
                list.add(i);
            }
        }
        
        // 리스트를 순회하면서 data에서 값 뽑고 answer에 넣어주기
        int[][] answer = new int[list.size()][4];
        for(int i=0; i<list.size(); i++){
            int index = list.get(i);
            for(int j=0; j<4; j++){
                answer[i][j] = data[index][j];
            }
        }
        final int finalSortByIndex = sort_by_index; 
        Arrays.sort(answer, (o1, o2) -> {
            return o1[finalSortByIndex] - o2[finalSortByIndex];
        });
        
        return answer;
    }
}