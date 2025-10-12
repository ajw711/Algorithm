class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String pattern = "^(aya|ye|woo|ma)+$";
        String repeatPattern = ".*(aya|ye|woo|ma)\\1.*"; 
        
        for (String word : babbling) {
            if (word.matches(pattern) && !word.matches(repeatPattern)) {
                answer++;
            }
        }
        return answer;
    }
}