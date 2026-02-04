import java.util.*;

class Solution {
    static class Node {
        List<int[]> point;

        public Node(List<int[]> point) {
            this.point = resizing(point);
        }

        private List<int[]> resizing(List<int[]> list) {
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for (int[] p : list) {
                minX = Math.min(minX, p[0]);
                minY = Math.min(minY, p[1]);
            }
            List<int[]> res = new ArrayList<>();
            for (int[] p : list) {
                res.add(new int[]{p[0] - minX, p[1] - minY});
            }
            // 정렬: (x기준 오름차순, 같으면 y기준 오름차순)
            res.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            return res;
        }

        public void rotate() {
            List<int[]> rotated = new ArrayList<>();
            for (int[] p : point) {
                // 시계 방향 회전: (x, y) -> (y, -x)
                rotated.add(new int[]{p[1], -p[0]});
            }
            this.point = resizing(rotated);
        }
    }

    private List<int[]> bfs(int[][] board, boolean[][] visited, int startX, int startY, int target) {
        List<int[]> list = new ArrayList<>();
        ArrayDeque<int[]> dp = new ArrayDeque<>();
        dp.add(new int[]{startX, startY});
        visited[startY][startX] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!dp.isEmpty()) {
            int[] cur = dp.poll();
            list.add(cur);

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length 
                    && !visited[ny][nx] && board[ny][nx] == target) {
                    visited[ny][nx] = true;
                    dp.add(new int[]{nx, ny});
                }
            }
        }
        return list;
    }

    private int compare(List<Node> pTable, List<Node> pBoard) {
        int answer = 0;
        boolean[] used = new boolean[pBoard.size()];
        
        for (Node piece : pTable) {
            for (int i = 0; i < pBoard.size(); i++) {
                Node space = pBoard.get(i);
                if (used[i] || piece.point.size() != space.point.size()) continue;

                boolean match = false;
                for (int r = 0; r < 4; r++) {
                    if (isSame(piece.point, space.point)) {
                        match = true;
                        break;
                    }
                    piece.rotate();
                }

                if (match) {
                    answer += piece.point.size();
                    used[i] = true;
                    break;
                }
            }
        }
        return answer;
    }

    private boolean isSame(List<int[]> p1, List<int[]> p2) {
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i)[0] != p2.get(i)[0] || p1.get(i)[1] != p2.get(i)[1]) return false;
        }
        return true;
    }

    public int solution(int[][] game_board, int[][] table) {
        int n = table.length;
        
        List<Node> pTable = new ArrayList<>();
        boolean[][] vTable = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vTable[i][j] && table[i][j] == 1) {
                    pTable.add(new Node(bfs(table, vTable, j, i, 1)));
                }
            }
        }

        List<Node> pBoard = new ArrayList<>();
        boolean[][] vBoard = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vBoard[i][j] && game_board[i][j] == 0) {
                    pBoard.add(new Node(bfs(game_board, vBoard, j, i, 0)));
                }
            }
        }

        return compare(pTable, pBoard);
    }
}