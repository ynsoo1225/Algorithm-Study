def solution(genres, plays):
    answer = []
    album = dict()
    
    for i, p in enumerate(plays):
        if genres[i] in album.keys():
            album[genres[i]][0] += p
            album[genres[i]].append([p, -i])
        else:
            album[genres[i]] = [p, [p, -i]]
    
    temp = []
    for x in sorted(list(album.values()), reverse = True):
        temp += sorted(x[1:], reverse = True)[:2]
    
    answer = [-1*t[1] for t in temp]
            
    return answer