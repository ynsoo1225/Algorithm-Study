def solution(routes):
    answer = 0
    routes.sort(key=lambda x:x[1]) #차량 진출 기준 정렬
    camera = -30001 #카메라 위치
    
    for route in routes:
        if camera < route[0]:
            answer += 1
            camera = route[1]
    return answer