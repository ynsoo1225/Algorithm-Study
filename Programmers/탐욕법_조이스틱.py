def solution(name):
    answer = 0
    a = []
    for i in name:
        a.append(min(ord(i)-ord('A'), 1+ord('Z')-ord(i)))
    if 'A' not in name:
        answer = len(name)-1 + sum(a)
    i = 0
    if 'A' in name:
        while True:
            answer += a[i]
            a[i] = 0
            if sum(a) == 0:
                break
            left, right = (1,1)
            while a[i-left] <= 0:
                left += 1
            while a[i+right] <= 0:
                right += 1
            if left<right:
                answer += left
                i += -left
            else:
                answer += right
                i += right
    return answer