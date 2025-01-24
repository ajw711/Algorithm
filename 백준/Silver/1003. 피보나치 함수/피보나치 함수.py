from collections import deque
import sys
import heapq

input = sys.stdin.readline


  


n=int(input())
for _ in range(n):
  x=int(input())
  zero=[1,0,1]
  one=[0,1,1]
  if x>2:
    for i in range(3,x+1):
      zero.append(zero[i-1]+zero[i-2])
      one.append(one[i-1]+one[i-2])
  print(zero[x],one[x])