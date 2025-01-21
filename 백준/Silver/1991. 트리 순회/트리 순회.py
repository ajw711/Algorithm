import sys
input = sys.stdin.readline


n = int(input())
tree = dict()
for i in range(n):
    root, left, right =input().split()
    tree[root] = [left, right]

def pre(root):
    if root == '.':
        return
    print(root, end='')
    pre(tree[root][0])
    pre(tree[root][1])

def ino(root):
    if root == '.':
        return
    ino(tree[root][0])
    print(root, end='')
    ino(tree[root][1])

def post(root):
    if root == '.':
        return
    post(tree[root][0])
    post(tree[root][1])
    print(root, end='')

pre('A')
print()
ino('A')
print()
post('A')