from collections import deque
import sys

input=sys.stdin.readline

def binary_search(arr,c,start,end):
  rs=0
  while start <= end:
      mid = (start + end) // 2
      install=arr[0]
      cnt=1
      for i in range(len(arr)):
        if arr[i]>=install+mid:
          install=arr[i]
          cnt+=1
      if cnt>=c:
        rs=mid
        start=mid+1
      else:
        end=mid-1
  return rs

n,c=map(int, input().split())
ls=[]
for _ in range(n):
  ls.append(int(input()))
ls.sort()
start=1
last=ls[-1]-ls[0]
print(binary_search(ls,c,start,last))