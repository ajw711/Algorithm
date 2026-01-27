class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[] lastChance = new int[schedules.length];
        for(int i=0; i<schedules.length; i++){
            int hour = schedules[i] / 100;
            int min = schedules[i] % 100 + 10;
            int total = hour * 60 + min;
            lastChance[i] = (total / 60 )* 100 + total % 60;
        }
        for(int i=0; i<timelogs.length; i++){
            boolean flag = true;
            for(int j=0; j<7; j++){
                int check = (j + startday - 1) % 7 + 1;
                if(check == 6 || check == 7) continue;
                
                if(lastChance[i] < timelogs[i][j]){
                    flag = false;
                    break;
                    
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}