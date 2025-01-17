import sys
from collections import deque
input= sys.stdin.readline

s = int(input())


def bfs(start_x, start_y):

    q = deque()
    q.appendleft((start_x,start_y))
    visited[start_x][start_y] = True
    while len(q) > 0:
        cx, cy =q.pop()
        for x,y in ((-1,0), (1,0), (0,-1), (0,1)):
            nx , ny = cx + x , cy+y
            if 0<=nx<n and 0<=ny<m and ls[nx][ny] == 1 :
                if visited[nx][ny]:
                    continue
                q.appendleft((nx, ny))
                visited[nx][ny] = True




for _ in range(s):

    m, n, k = map(int, input().split())
    ls = [[0]*m for _ in range(n)]
    visited = [[False]*m for _ in range(n)]
    bfs_check = []
    cnt = 0

    for _ in range(k):
        i, j = map(int, input().split())
        ls[j][i] = 1
        bfs_check.append((j, i))

    for x, y in bfs_check:
        if visited[x][y]:
            continue
        bfs(x,y)
        cnt += 1

    print(cnt)







