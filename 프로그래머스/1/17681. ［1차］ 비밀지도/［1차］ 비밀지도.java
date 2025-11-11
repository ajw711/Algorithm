import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            StringBuffer result = new StringBuffer();
            
 
            
            sb1.append(Integer.toBinaryString(arr1[i]));
            sb2.append(Integer.toBinaryString(arr2[i]));
            
            while(sb1.length() < n){
                sb1.insert(0, '0');
            }
            while(sb2.length() < n){
                sb2.insert(0, '0');
            }
                
            for(int j=0; j<n; j++){
                if( sb1.charAt(j) == '0' && sb2.charAt(j) == '0'){
                    result.append(' ');
                }else{
                    result.append('#');
                }
            }
            answer[i] = result.toString();
        }
        
        return answer;
    }
}