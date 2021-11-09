def solution(N, number):
    dp = [[]]
    for i in range(1, 10):
        case = []
        for j in range(1, i):
            for k in dp[j]:
                for l in dp[i-j]:
                    case.append(k+l)
                    case.append(abs(k-l))
                    case.append(k*l)
                    if min(k,l) != 0:
                        case.append(max(k,l)/min(k,l))
        case.append(int(str(N)*i))
        if number in case:
            return i
        dp.append(list(set(case)))
    return -1