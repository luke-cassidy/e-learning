# -*- coding: utf-8 -*-
"""
Created on Tue Sep  6 17:22:54 2016

@author: Luke


x=int (input("Enter an integer: ") )

ans = 0

while(ans**3 < abs(x)):
    ans = ans + 1

if ans**3 != abs(x):
    print(str(x) + " is not a perfect cube")

else:
    if x < 0:
        ans = - ans
    print("Cube root of " + str(x) + " is " + str(ans))


school = 'Massachusetts Institute of Technology'
numVowels = 0
numCons = 0

for char in school:
    if char == 'a' or char == 'e' or char == 'i' \
       or char == 'o' or char == 'u':
        numVowels += 1
    elif char == 'o' or char == 'M':
        print(char)
    else:
        numCons -= 1

print('numVowels is: ' + str(numVowels))
print('numCons is: ' + str(numCons)) 

"""

