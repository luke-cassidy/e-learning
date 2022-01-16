# -*- coding: utf-8 -*-
"""
Created on Thu Sep  8 17:31:45 2016

@author: Luke
"""
"""
def is_even(i, j):
    
    i + j - 2

print(is_even)
print(type(is_even))

def is_odd(k):
    return k
    
print(is_odd < is_even)

"""
"""
str1 = "exterminate!"
str2 = "Number one - the larch"

print(type(str1.count("e")))
print(str1.replace("e","*"))
print(type(str2.find("!")))
print(str2.index('n'))




def recurPower(base, exp):
    '''
    base: int or float.
    exp: int >= 0
 
    returns: int or float, base^exp
    '''
    
    if exp > 1:
        return recurPower(base, (exp-1)) * base
    
    elif exp == 1:
        return base
        
    else:
        return 1
        
    
x = iterPower(3,1)

print(x)



def iterPower(base, exp):
    '''
    base: int or float.
    exp: int >= 0
 
    returns: int or float, base^exp
    '''
    ans = base
    
    while exp > 1:
            ans *= base
            exp -= 1
            
    if exp > 0:
        return ans 
      
    else:
        return 1
           
    
x = iterPower(2,3)

print(x)



def gcdIter(a, b):
    '''
    a, b: positive integers
    
    returns: a positive integer, the greatest common divisor of a & b.
    '''
    if a < b:
        i = a
    else:
        i = b
        
    while i > 1:
        if a % i == 0 and b % i == 0:
            return i
        else:
            i -= 1
      
x = gcdIter(12,8)

print(x)



def gcdRecur(a, b):
    '''
    a, b: positive integers
    
    returns: a positive integer, the greatest common divisor of a & b.
    '''
    
    if b == 0:
        return a
    else:
        return gcdRecur(b, a%b)

x = gcdRecur(12,9)

print(x)


aStr = "abcdefg"
char = "z"

def isIn(char, aStr):
    '''
    char: a single character
    aStr: an alphabetized string
    
    returns: True if char is in aStr; False otherwise
    '''
    if aStr == "" and char != "":
        return False
          
    elif char == aStr[int(len(aStr)/2)]:
        return True
        
    elif len(aStr) <= 1 and char != aStr:
        return False
    

    elif char < aStr[int(len(aStr)/2)]:
        return isIn(char, aStr[:int(len(aStr)/2)])
        
    elif char > aStr[int(len(aStr)/2)]:
        return isIn(char, aStr[int(len(aStr)/2):])
    
        
x = isIn(char, aStr)

print(x)

"""

def isIn(char, aStr):
    '''
    char: a single character
    aStr: an alphabetized string
    
    returns: True if char is in aStr; False otherwise
    '''
    i = int(len(aStr)/2)
    if len(aStr) == 0:
        return False
    elif char == aStr[i]:
        return True
    elif len(aStr) < 2:
        return False
    elif char > aStr[i]:
        return isIn(char, aStr[i:len(aStr)])
    else:
        return isIn(char, aStr[0:i])
  

a = "h"
b = "abcdefg"
      
print(isIn(a,b))


















