class Solution {
    
    static int converter(String s){
        String[] target = s.split(":");
        int min = Integer.parseInt(target[0]) * 60;
        int sec = Integer.parseInt(target[1]);
        return min + sec; 
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        
        String answer = "";
        int cur = converter(pos);
        int opStart = converter(op_start);
        int opEnd = converter(op_end);
        int videoLen = converter(video_len);
        
        if(opStart<=cur && cur<=opEnd){
            cur = opEnd;
        }
        
        for(String s: commands){
            if(s.equals("next")){
                cur +=10;
                if(cur > videoLen) cur = videoLen;
            } else { //prev
                cur -=10;
                if(cur < 0) cur = 0;
            }
            
            if(cur >= opStart && cur <= opEnd) cur = opEnd;
        }
        
        answer = String.format("%02d:%02d",cur/60, cur%60);
        return answer;
    }
}