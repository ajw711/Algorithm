from collections import deque
import sys

input=sys.stdin.readline


def binary_search(arr, target, start, end):
  while start<=end:
    mid=(start+end)//2
    if arr[mid]==target:
      return True
    elif arr[mid]>target:
      end=mid-1
    else:
      start=mid+1
  return False
  

n=int(input())
ls1=list(map(int, input().split()))
m=int(input())
ls2=list(map(int, input().split()))

ls1.sort()

for i in ls2:
  rs=binary_search(ls1,i,0,n-1)
  if rs:
    print(1)
  else:
    print(0)

