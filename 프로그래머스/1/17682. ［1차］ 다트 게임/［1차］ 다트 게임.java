class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int idx = -1;
        int len = dartResult.length();

        for(int i=0; i<len; i++){
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)){
                idx++;
                if(c == '1' && i + 1 < len && dartResult.charAt(i + 1) == '0'){
                    score[idx] = 10;
                    i++;
                }else{
                    score[idx] = c -'0';
                }
            }
            
            else if (c == 'S') {
                score[idx] = (int)Math.pow(score[idx], 1);
            } else if (c == 'D') {
                score[idx] = (int)Math.pow(score[idx], 2);
            } else if (c == 'T') {
                score[idx] = (int)Math.pow(score[idx], 3);
            }
            
            else if (c == '*') {
                score[idx] *= 2;
                if (idx > 0) score[idx - 1] *= 2;
            } else if (c == '#') {
                score[idx] *= -1;
            }
            
        }
        
        return score[0] + score[1] + score[2]; 
    }
}