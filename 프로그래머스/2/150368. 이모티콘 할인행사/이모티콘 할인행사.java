import java.util.*;

class Solution {
    static int[] discounts = {10, 20, 30, 40};
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, emoticons, new int[emoticons.length], users);
        return answer;
    }

    static void dfs(int depth, int[] emoticons, int[] applied, int[][] users) {
        if (depth == emoticons.length) {
            calc(users, emoticons, applied);
            return;
        }

        for (int d : discounts) {
            applied[depth] = d;
            dfs(depth + 1, emoticons, applied, users);
        }
    }

    static void calc(int[][] users, int[] emoticons, int[] applied) {
        int join = 0;
        int total = 0;

        for (int[] user : users) {
            int minRate = user[0];
            int maxCost = user[1];
            int cost = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (applied[i] >= minRate) {
                    cost += emoticons[i] * (100 - applied[i]) / 100;
                }
            }

            if (cost >= maxCost) join++;
            else total += cost;
        }

        if (join > answer[0]) {
            answer[0] = join;
            answer[1] = total;
        } else if (join == answer[0]) {
            answer[1] = Math.max(answer[1], total);
        }
    }
}
