def dfs(depth,a):
    if depth == m:
        for i in range(m):
            print(stack[i], end=' ')

        print()  # 한 줄에 출력한 후 개행
        return 
    for i in range(a, n + 1):
        if visited[i]:
            continue
        visited[i] = True
        stack.append(i)
        dfs(depth + 1,i+1)
        stack.pop()
        visited[i] = False

n, m = map(int, input().split())
visited = [False] * (n + 1)
stack = []
dfs(0,1)