import sys
from collections import deque
input= sys.stdin.readline

n = int(input())
m = int(input())
ls = [[] for _ in range(n+1)]
visited =[False]*(n+1)
for _ in range(m):
    i,j = map(int , input().split())
    ls[i].append(j)
    ls[j].append(i)

cnt =0

def bfs(s):
    global cnt
    q=deque()
    q.appendleft(s)
    visited[s]=True


    while len(q) > 0:
        cur =q.pop()

        for i in ls[cur]:
            if visited[i]:
                continue
            q.appendleft(i)
            visited[i]=True
            cnt +=1

bfs(1)
print(cnt)
