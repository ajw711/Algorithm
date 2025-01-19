import sys
from collections import deque
input = sys.stdin.readline


def bfs():

    q = deque()
    visited = [[0]* m for _ in range(n)]

    for i in range(n):
        for j in range(m):
           if ls[i][j] == 1:
               q.appendleft((i,j))
               visited[i][j] = 1
    rs = 0

    while len(q)>0:
        cx, cy =q.pop()
        for x, y in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nx, ny = cx+x, cy+y
            if 0<=nx<n and 0<=ny <m and ls[nx][ny] == 0 and visited[nx][ny] == 0:
                ls[nx][ny]=1
                q.appendleft((nx, ny))
                visited[nx][ny] = visited[cx][cy]+1
                rs = max(rs, visited[nx][ny])

    for x in range(n):
        for y in range(m):
            if ls[x][y] == 0:
                return -1
    if rs == 0:
        return 0
    return rs-1



m, n = map(int, input().split())
ls = [list(map(int, input().split())) for _ in range(n)]
min_value = bfs()
print(min_value)






