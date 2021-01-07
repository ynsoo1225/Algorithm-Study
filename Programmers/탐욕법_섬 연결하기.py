def solution(n, costs):
    answer = 0
    costs.sort(key = lambda x: x[2]) #cost 기준 오름차순 정렬
    routes = set([costs[0][0]]) 
    while len(routes) != n:
        for i, cost in enumerate(costs):
            if cost[0] in routes and cost[1] in routes: #이미 도달 가능하면 continue
                continue
            if cost[0] in routes or cost[1] in routes: #경로 없으면
                routes.update([cost[0],cost[1]]) #최소 비용 경로 추가
                answer += cost[2] #비용 더하기
                costs[i] = [-1, -1, -1] 
                break
    return answer