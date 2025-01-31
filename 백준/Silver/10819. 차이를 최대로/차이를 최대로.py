def dfs(depth):
    if depth == n:
        current = 0
        for i in range(n - 1):
            current += abs(stack[i] - stack[i + 1])
        global max_value
        max_value = max(max_value, current)
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            stack.append(ls[i])
            dfs(depth + 1)
            stack.pop()
            visited[i] = False


n = int(input())
ls = list(map(int, input().split()))
visited = [False] * n
stack = []
max_value = -1
dfs(0)
print(max_value)