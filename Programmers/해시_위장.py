# def solution(clothes):
#     answer = 1
#     clothes_dict = dict()
    
#     for cloth in clothes:
#         if cloth[1] in clothes_dict.keys():
#             clothes_dict[cloth[1]] += 1
#         else:
#             clothes_dict[cloth[1]] = 1
    
#     for v in clothes_dict.values():
#         answer *= (v+1)

from collections import Counter
from functools import reduce

def solution(clothes):
    cc = Counter([kind for name, kind in clothes])    
    answer = reduce(lambda x, y: x*(y+1), cc.values(), 1) -1
    return answer