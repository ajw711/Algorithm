import java.util.*;
class Solution {
    
    static class Song{
        int index;
        int play;
        
        public Song(int index, int play){
            this.index = index;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {

        // step1. 장르별로 (고유번호, 재생횟수) 저장 + 장르 총 재생횟수 누적
        // step2. 각 장르 내부에서
        //        재생횟수 내림차순,
        //        같으면 고유번호 오름차순 정렬
        // step3. 장르를 총 재생횟수 기준 내림차순 정렬
        // step4. 장르 순서대로 상위 2곡씩 answer에 추가
 
        Map<String, List<Song>> genreMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
           
            genreMap.putIfAbsent(genres[i], new ArrayList<>());
            genreMap.get(genres[i]).add(new Song(i, plays[i]));
            
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for(List<Song> list : genreMap.values()){
            Collections.sort(list, (a,b) ->{
                if(a.play != b.play) return b.play - a.play;
                return a.index - b.index;
            });
        }
        

        List<String> genreSort = new ArrayList<>(genreMap.keySet());
        Collections.sort(genreSort, (a,b) -> totalMap.get(b) - totalMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        for(String s : genreSort){
            List<Song> list = genreMap.get(s);
            for(int i=0; i<Math.min(2, list.size()); i++){
                result.add(list.get(i).index);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}