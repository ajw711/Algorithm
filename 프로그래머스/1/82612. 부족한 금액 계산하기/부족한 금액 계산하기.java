class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
       
        if( (long) (((1+count) * count)/2) * price - money < 0){
            return 0;
        }

        return (long) (((1+count) * count)/2) * price - money ;
    }
}