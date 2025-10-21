class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            
            if(i==1){
                answer-=1;
                continue;
            }
            
            int count = 2;
            for(int j=2; j<=i/2; j++){
                if(i % j == 0) count+=1;
            }
    
            
            if(count % 2 == 0) {
                answer += i;
            }else{
                answer -= i;
            }
        }
        
        return answer;
    }
}