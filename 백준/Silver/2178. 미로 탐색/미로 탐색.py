import sys
from collections import deque
input= sys.stdin.readline

n, m =map(int, input().split())
ls = [list(map(int, input().rstrip())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]


def bfs(si,sj, ei, ej):
    q = deque()
    q.appendleft((si,sj))
    visited[si][sj] = 1

    while len(q) > 0:
        ci, cj = q.pop()
        if (ci,cj) == (ei,ej):
            return

        for x, y in ((-1,0),(1,0),(0,-1),(0,1)):
            ni, nj =ci+x, cj+y
            if 0<=ni<n and 0<=nj<m and ls[ni][nj] == 1 and visited[ni][nj] == 0:
                q.appendleft((ni,nj))
                visited[ni][nj] = visited[ci][cj]+1

bfs(0,0,n-1,m-1,)
print(visited[n-1][m-1])