import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().split())
ls = sorted(list(map(int, input().split())))



def dfs(depth,a ,rs):

    if depth == m:
        for i in rs:
            print(i, end=' ')
        print()
        return

    for i in range(a,n):
        dfs(depth+1,i,rs+[ls[i]])


dfs(0,0,[])
