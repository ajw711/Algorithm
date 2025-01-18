import sys
from collections import deque
input= sys.stdin.readline


def bfs(start_x, start_y):

    q = deque()
    q.appendleft((start_x,start_y))
    visited[start_x][start_y] = 1

    rs = 1

    while len(q)>0:
        cx ,cy = q.pop()
        for x, y  in ((-1,0), (1,0), (0,-1), (0,1)):
            nx, ny =cx+x ,cy+y
            if 0<=nx<n and 0<=ny<n and ls[nx][ny] == 1:
                if visited[nx][ny] > 0:
                    continue
                q.appendleft((nx, ny))
                visited[nx][ny] = visited[cx][cy]+1
                rs+=1

    return rs



n = int(input())
ls = [list(map(int,input().rstrip())) for _ in range(n)]
visited = [[0]*n for _ in range(n)]
visited_check=[]
for i in range(n):
    for j in  range(n):
        if ls[i][j] == 1:
            visited_check.append((i,j))

cnt = 0
rs=[]

for x,y in visited_check:
    if visited[x][y] > 0:
        continue
    rs.append(bfs(x,y))
    cnt+=1

rs.sort()
print(cnt)
for i in rs:
    print(i)






