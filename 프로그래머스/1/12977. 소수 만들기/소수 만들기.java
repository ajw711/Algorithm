class Solution {
    
    static int answer = 0;
    
    static void combination(int arr[], int[] nums, int start, int depth){
        
        if(depth == 3){
            int result = 0;
            for(int i=0; i<3; i++){
                result+=arr[i];
            }
            
            if(isPrime(result)){
                answer++;
            }
              return;
        }
        
        for(int i=start; i<nums.length; i++){
            arr[depth] = nums[i]; 
            combination(arr, nums, i+1, depth+1);
            
        }
    }
    
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2;  i * i <= n; i++) {
            if (n % i == 0) {
                return false; 
            }
        }
        return true; 
    }
    
    public int solution(int[] nums) {
         answer = 0;
        int[] arr = new int[3];
 
        combination(arr, nums, 0, 0);

        return answer;
    }
}