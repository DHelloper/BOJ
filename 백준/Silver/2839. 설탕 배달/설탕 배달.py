a = int(input())
result = 0
while True:
    if a%5==0:
        result += a//5
        print(result)
        break
    a-=3
    result += 1
    
    if a<0:
        print(-1)
        break