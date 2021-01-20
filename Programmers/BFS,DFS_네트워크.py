def solution(n, computers):
    answer = 0
    visited = [0]*n
    bfs = []
    
    while 0 in visited:
        bfs.append(visited.index(0))
        while bfs:
            node = bfs.pop(0)
            visited[node] = 1
            for i in range(n):
                if visited[i] == 0 and computers[node][i] == 1:
                    bfs.append(i)
        answer += 1
    return answer