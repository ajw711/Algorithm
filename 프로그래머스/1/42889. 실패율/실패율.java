import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int stage : stages) {
            countMap.put(stage, countMap.getOrDefault(stage, 0) + 1);
        }


        int total = stages.length;
        List<double[]> failList = new ArrayList<>();


        for (int i = 1; i <= N; i++) {
            int failCount = countMap.getOrDefault(i, 0);
            double failRate = total == 0 ? 0.0 : (double) failCount / total;
            failList.add(new double[]{i, failRate});
            total -= failCount;
        }


        failList.sort((a, b) -> {
            if (a[1] == b[1]) return Double.compare(a[0], b[0]);
            return Double.compare(b[1], a[1]);
        });


        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failList.get(i)[0];
        }

        return answer;
    }
}