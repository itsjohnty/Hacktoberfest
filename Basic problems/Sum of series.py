# Program to calculate the sum of series upto n terms. For example, if value=2 and n=5 the series will become 2 + 22 + 222 + 2222 + 22222 = 24690

def series():
    list1 = []
    x = ""
    sum = 0
    for i in range(n):
        x += value
        int_element = int(x)
        sum = sum + int_element
        plus = " + "
        list1.append(x)
        list1.append(plus)

    y = len(list1)

    for i in range(y-1):
        element = list1[i]
        print(element,end="")
    print(" =",sum)

value=input("Enter a number : ")
n = int(input("Enter a number till which you want the sum of series : "))
series()