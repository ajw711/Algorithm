import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().split())
visited = [[] for _ in range(n+1)]
visited_check = [False]*(n+1)
for _ in range(m):
  s, e =map(int, input().split())
  visited[s].append(e)
  visited[e].append(s)
  
def bfs():

  q = deque()
  cnt = 0
  for i in range(1, n+1):
    if visited_check[i]:
      continue
    q.appendleft(i)
    visited_check[i]=True
    
    while len(q)>0:
      next = q.pop()
      for i in visited[next]:
        if visited_check[i]:
          continue
        q.appendleft(i)
        visited_check[i] = True
    cnt +=1

  return cnt
print(bfs())