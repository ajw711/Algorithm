from collections import deque
import sys

input=sys.stdin.readline
def binary_search(arr, k,n, start, end):
    while start<=end:
      mid=(start+end)//2
      cnt=0
      for i in range(k):
        if arr[i]>=mid:
          cnt+=arr[i]-mid
      if cnt>=n:
        start=mid+1
      else:
        end=mid-1
    return end
  

k,n=map(int,input().split())
ls=list(map(int, input().split()))
ls.sort()
last=max(ls)
print(binary_search(ls,k,n,1,last))

