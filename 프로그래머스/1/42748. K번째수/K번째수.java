import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int seq=0; seq<commands.length; seq++){
            
            int i = commands[seq][0];
            int j = commands[seq][1];
            int k = commands[seq][2];
            int[] arr = new int[j-i+1];
            int cnt = 0;
            for(int next=i; next<=j; next++){
                arr[cnt++] = array[next-1];
            }
            
            Arrays.sort(arr);
            answer[seq] = arr[k-1];
        }
        
        return answer;
    }
}