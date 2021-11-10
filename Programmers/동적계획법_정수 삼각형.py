def solution(triangle):
    answer = 0
    L = len(triangle)
    for i in range(L-2, -1, -1):
        temp = []
        for j in range(len(triangle[i])):
            temp.append(max(triangle[i][j]+triangle[i+1][j], triangle[i][j]+triangle[i+1][j+1]))
        triangle[i] = temp
        # print(temp)
    return max(temp)