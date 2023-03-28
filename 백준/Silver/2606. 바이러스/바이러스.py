n = int(input())
m = int(input())
visited = [False] * (n+1)
matrix = [[0]*(n+1) for i in range(n+1)]
count = 0
for i in range(m):
    a,b = map(int,input().split())
    matrix[a][b] = matrix[b][a] = 1

def DFS(v):
    global count
    visited[v] = True
    for i in range(1, n+1):
        if(visited[i] == False and matrix[v][i] == 1):
            DFS(i)
            count += 1
    return count

print(DFS(1))
