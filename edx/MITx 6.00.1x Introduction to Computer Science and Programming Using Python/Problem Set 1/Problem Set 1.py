# -*- coding: utf-8 -*-
"""
Created on Wed Sep  7 14:49:14 2016

@author: Luke
"""
"""

s = "bcdfgh"

count = 0

for letter in s:
    if letter == "a" or letter=="e" or letter == "i" or letter == "o" or letter == "u":
        count += 1

print("Number of vowels: " + str(count))
.......................................

s = 'azcbobobegghakl'

increment = 0
count = 0

for letter in s:
    if "bob" == s[increment:(increment + 3)]:
        count += 1
    increment += 1
        
print("Number of times bob occurs is: " + str(count))
.............................................

s = "ffyoqdxf"

finalString = ""

for i in range (len(s)):
    for j in range (i+1, len(s)):
        
        if s[j] >= s[j-1]:
            string = s[i:j+1]

            if len(string) > len(finalString):
                finalString = string
        
        elif i == 0 and j == 1: 
            finalString = s[0]
            break
        
        else:
            break
                               
print(finalString)

"""

s = "ffyoqdxf"

finalString = ""

for i in range (len(s)):
    for j in range (i+1, len(s)):
        
        if s[j] >= s[j-1]:
            string = s[i:j+1]

            if len(string) > len(finalString):
                finalString = string
        
        elif i == 0 and j == 1: 
            finalString = s[0]
            break
        
        else:
            break
                               
print("Longest substring in alphabetical order is: " + str(finalString))