# -*- coding: utf-8 -*-
"""
Created on Mon Jul  3 16:46:34 2017

@author: luke_
"""

#x = "pi"
#y = "pie"
#
#x, y = y, x
#
#
#def f(x):
#    print(x)
#    while x > 3:
#        f(x+1)
#        
#i = -1
#j = -1
#
#while i >= 0:
#    while j >= 0:
#        print(i, j)
# 
#def g():
#    return 0
#
#a = g
#
#def h(x):
#    a = []
#    while x > 0:
#        a.append(x)
#        h(x-1)
#        
##h(2)
#
#L = {"1":1, "2":2, "3":3}
#
#keys = list(L.keys())
#
#print(type(keys[1]))
#
#print(len(L))
#
#def function():
#    while True:
#        print("loop terminate")
#        break
#    print("function terminate")
#    
#
#function()
#print("program terminate")
#
#s = [1,2,3,4,4]
#
#s[2] = 3
#
#
#L = [1,2,3]
#d = {'a': 'b'}
#def i(x):
#    return 3
#    
#for j in range(10, -1, -2):
#    print(i)
#    
#    
#stuff  = "iQ"
#for thing in stuff:
#    if thing == 'iQ':
#        print("Found it")
#        
#
#
#def Square(x):
#    return SquareHelper(abs(x), abs(x))
#
#def SquareHelper(n, x):
#    if n == 0:
#        return 0
#    return SquareHelper(n-1, x) + x
#    
#print(Square(-21))
#

#def is_triangular(k):
#    """
#    k, a positive integer
#    returns True if k is triangular and False if not
#    """
#    count = 1
#    element = [count]
#    
#    while True:
#        if sum(element) == k:
#            return True
#        elif sum(element) < k:
#            count += 1
#            element.append(count)
#        else:
#            return False
#            
#print(is_triangular(9))




#def print_without_vowels(s):
#    '''
#    s: the string to convert
#    Finds a version of s without vowels and whose characters appear in the 
#    same order they appear in s. Prints this version of s.
#    Does not return anything
#    '''
#    vowels = "aeiouAEIOU"
#    newString = ""
#    for char in s:
#        if char not in vowels:
#            newString += char
#    print(newString)
#
#
#s = "AEIOUaeiou these are vowels"
#print_without_vowels(s)
#
#            



#def largest_odd_times(L):
#    """ Assumes L is a non-empty list of ints
#        Returns the largest element of L that occurs an odd number 
#        of times in L. If no such element exists, returns None """
#    while True:
#        if len(L) > 0:
#            
#            large = max(L)
#            num = L.count(large)
#            
#            if num%2 != 0:
#                return large
#            else:
#                while large in L:
#                    L.remove(large)
#        else:
#            return None
#    
#a = [2,2,4,4]
#b = [3,9,5,3,5,3]
#c = []
#d = [2,2]
#e = [1,2,2,3,3,45,45]
#print(largest_odd_times(e))
#print(largest_odd_times(d) )


#def dict_invert(d):
#    '''
#    d: dict
#    Returns an inverted dictionary according to the instructions above
#    '''
#    
#    newDict = {}
#    keys = list(d.keys())
#    values = list(d.values())
#    newKeys = keys
#    
##    for element in keys:
##        newKeys.append(str(element))
#        
#    print(newKeys)
#    for i in range(len(d)):
#
#        if values[i] in newDict:
#            newDict[values[i]].append(newKeys[i])
#            newDict[values[i]].sort()
#        else:
#            newDict[values[i]] = list(newKeys[i])
#                
#    return newDict


#def dict_invert(d):
#    '''
#    d: dict
#    Returns an inverted dictionary according to the instructions above
#    '''
#    
#    newDict = {}
#    keys = list(d.keys())
#    values = list(d.values())
#
#    for i in range(len(d)):
#
#        if values[i] in newDict:
#            newDict[values[i]].append(keys[i])
#            newDict[values[i]].sort()
#        else:
#            newDict[values[i]] = [keys[i]]
#                
#    return newDict
#  
#d = {1:10, 2:20, 3:30} 
#e = {1:10, 2:20, 3:30, 4:30} 
#f = {4:True, 2:True, 0:True}
#
#print(dict_invert(d))
#print(dict_invert(e))
#print(dict_invert(f))    


#def general_poly (L):
#    """ L, a list of numbers (n0, n1, n2, ... nk)
#    Returns a function, which when applied to a value x, returns the value 
#    n0 * x^k + n1 * x^(k-1) + ... nk * x^0 """
#    
#    def b(base):
#        ans = 0
#        for i in range(len(L)):
#            ans += L[i]*(base**(len(L)-i-1))
#        return ans
#    
#    return b
#    
#L1 = [1, 2, 3, 4]
#L2 = [1]
#L3 = [0]
#L4 = [-1]
#L5 = [2.5]
#L6 = [-1,-2,-3,-4]
#b0 = 10
#b1 = 0
#b2 = 1
#b3 = -1
#b4 = -2.5
#    
#print(general_poly(L6)(b0))


def is_list_permutation(L1, L2):
    '''
    L1 and L2: lists containing integers and strings
    Returns False if L1 and L2 are not permutations of each other. 
            If they are permutations of each other, returns a 
            tuple of 3 items in this order: 
            the element occurring most, how many times it occurs, and its type
    '''
    if len(L1) == 0 and len(L2) == 0:
        return (None, None, None)
    
    elif len(L1) == len(L2):
        
        elementCount = 0
        
        while len(L1) > 0:
            i = L1[0]
            
            if L1.count(i) > elementCount:
                element = i
                elementCount = L1.count(i)
                elementType = type(i)
            
            if L1.count(i) == L2.count(i):
                while i in L1:
                    L1.remove(i)
                    L2.remove(i)
            else:
                return False
        
        return (element, elementCount, elementType)
        
    else:
        return False

L1 = ['a', 'a', 'b']
L2 = ['a', 'b']
L3 = [1, 'b', 1, 'c', 'c', 1]
L4 = ['c', 1, 'b', 1, 1, 'c']
L5 = [1]
L6 = ["1", 1]
L7 = [3, '5', 7, 1]
L8 = [1, 2, 3, '5', 7]

print(is_list_permutation(L4, []))

