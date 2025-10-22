class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int count = 0;
        
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0){
                zero++;
            }
        }
        
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    count++;
                }                
            }
        }
        answer[0] = count+zero != 0 ? 7- (count + zero) : 6 ;
        answer[1] = count !=0 ? 7-count : 6;

        
        return answer;
    }
}