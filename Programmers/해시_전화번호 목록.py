def solution(phone_book):
    
    phone_book = sorted(phone_book)
    
    for p, q in zip(phone_book, phone_book[1:]):
        if q.startswith(p):
            return False
    
    return True