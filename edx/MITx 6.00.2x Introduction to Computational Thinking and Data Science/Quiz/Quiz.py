# -*- coding: utf-8 -*-
"""
Created on Sat Nov 25 16:47:41 2017

@author: luke_
"""

import random
#
##def f(x):
##    # x is an integer
##    return int(x + random.choice([0.25, 0.5, 0.75]))
##    
##print(f(100))
##
##for i in range(100):
##    r = random.random()
##    if r > 0.99:
##        print(r)
##    
##def A():
##    mylist = []
##    r = 1
##
##    if random.random() > 0.99:
##        r = random.randint(1, 10)
##    for i in range(r):
##        random.seed(0)
##        if random.randint(1, 10) > 3:
##            number = random.randint(1, 10)
##            print(number)
##            mylist.append(number)
##    print(mylist)
##    
##A()
#
#def F():
#    mylist = []
#    r = 1
#
#    if random.random() > 0.99:
#        r = random.randint(1, 10)
#    for i in range(r):
#        random.seed(0)
#        if random.randint(1, 10) > 3:
#            number = random.randint(1, 10)
#            if number not in mylist:
#                mylist.append(number)
#    return mylist
#
##def G():  
##    random.seed(0)
##    mylist = []
##    r = 1
##
##    if random.random() > 0.99:
##        r = random.randint(1, 10)
##    for i in range(r):
##        if random.randint(1, 10) > 3:
##            number = random.randint(1, 10)
##            mylist.append(number)
##            return mylist
#
#print(F())
##print(G())
#
#for i in range(10000):
#    a = F()
#    if len(a) != 1:
#        print(a)
#        
#for i in range(10):
#    random.seed(0)
#    print(random.randint(1, 10))
#        
#def greedySum(L, s):
#    """ input: s, positive integer, what the sum should add up to
#               L, list of unique positive integers sorted in descending order
#        Use the greedy approach where you find the largest multiplier for 
#        the largest value in L then for the second largest, and so on to 
#        solve the equation s = L[0]*m_0 + L[1]*m_1 + ... + L[n-1]*m_(n-1)
#        return: the sum of the multipliers or "no solution" if greedy approach does 
#                not yield a set of multipliers such that the equation sums to 's'
#    """
#    result = []
#    sCopy = s
#    
#    for pInt in L: 
#        mult = int(sCopy/pInt)
#        result.append(int(mult))
#        newS = sCopy - pInt*mult
#        sCopy = newS
#    
#    ans = sum([x * y for x, y in zip(result, L)])
#    if len(result) == 0 or ans != s:
#        return 'no solution'
#    else:
#        return sum(result)
#
#print(greedySum([10, 5, 1], 14))

#def max_contig_sum(L):
#    """ L, a list of integers, at least one positive
#    Returns the maximum sum of a contiguous subsequence in L """
#    maxSum = L[0]
#
#    for i in range(len(L)):
#        conSum = L[i]
#        for j in range(i, len(L)):
#            if L[i] == L[j]:
#                conSum = L[i]
#            else:
#                conSum += L[j]
#            if conSum > maxSum:
#                maxSum = conSum
#                
#    return maxSum
#    
#L = [3, 4, -1, 5, -4]
#print(max_contig_sum(L))  

def solveit(test):
    """ test, a function that takes an int parameter and returns a Boolean
        Assumes there exists an int, x, such that test(x) is True
        Returns an int, x, with the smallest absolute value such that test(x) is True 
        In case of ties, return any one of them. 
    """
    try:
        x = 100
        while x >= -100:
            if test(x) == True:
                return x
            else:
                x -= 1
    except:
        return 3

#### This test case prints 49 ####
def f(x):
    return (x+15)**0.5 + x**0.5 == 15
print(solveit(f))

#### This test case prints 0 ####
def f(x):
    return x == 0
print(solveit(f))

def f(x):
    return [1,2,3][-x] == 1 and x != 0
print(solveit(f))
