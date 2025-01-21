import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


n = int(input())
visited = [False]*(n+1)
tree = [[] for _ in range(n+1)]
rs = [0]*(n+1)

for _ in range(n-1):
    n1, n2 = map(int, input().split())
    tree[n1].append(n2)
    tree[n2].append(n1)



def dfs(number):
    visited[number] = True
    for i in tree[number]:
        if visited[i]:
            continue
        rs[i] = number
        dfs(i)

dfs(1)

for i in range(2,n+1):
    print(rs[i])