import sys
from collections import deque
input = sys.stdin.readline

ls = [list(map(int ,input().split())) for _ in range(9)]


def check(board, row, col, num):

    for x in range(9):
        if board[col][x] == num:
            return False

    for y in range(9):
        if board[y][row] == num:
            return False

    start_row, start_col = 3*(row//3), 3*(col//3)
    for i in range(3):
        for j in range(3):
            if board[start_col+j][start_row+i] == num:
                return False

    return True


def dfs(board):

    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                for num  in range(1,10):
                    if check(board, j,i,num):
                        board[i][j] = num
                        if dfs(board):
                            return True

                        board[i][j] = 0

                return False
    return True

dfs(ls)

for i in ls:
    print(*i)





