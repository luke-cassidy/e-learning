# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
"""
def getData(aTuple):
    nums = ()
    words = ()
    
    for t in aTuple:
        nums = nums + (t[0],)
        
        if t[1] not in words:
            words = words + (t[1],)
            
    min_nums = min(nums)
    max_nums = max(nums)
    unique_words = len(words)
    return (min_nums, max_nums, unique_words)
    



x = (1, 2, (3, 'John', 4), "Hi")


print(x[-1][-1])
print(3 in x)

"""
"""
def oddTuples(aTup):
    
    newTup = ()
    
    for i in range(len(aTup)+1):
        if i % 2 != 0:
            newTup = newTup + (aTup[i-1],)
        
    return newTup


aTup = ("I", "am", "a", "test", "tuple")

print(oddTuples(aTup))


listA = [100, 0, 1, 4, 7, 4, 1, 6, 3, 4]
listB = ['x', 'z', 't', 'q']

print(listA.pop(4))

print(listA.reverse())

print(listA)



def applyToEach(L, f):
    for i in range(len(L)):
        L[i] = f(L[i])
        
        
testList = [1, -4, 8, -9]
       
applyToEach(testList, abs)

print(testList)


def applyToEach(L, f):
    for i in range(len(L)):
        L[i] = f(L[i])

def plusOne(l):
     l += 1
     return l
        
testList = [1, -4, 8, -9]
       
applyToEach(testList, plusOne)

print(testList)




def applyToEach(L, f):
    for i in range(len(L)):
        L[i] = f(L[i])

def square(l):
     l = l**2
     return l
        
testList = [1, -4, 8, -9]
       
applyToEach(testList, square)

print(testList)



def oddTuples(aTup):
    '''
    aTup: a tuple
    
    returns: tuple, every other element of aTup. 
    '''
    oddTup = ()
    
    for tup in range(0,len(aTup),2):
        oddTup += (aTup[tup],)
            
    return oddTup


aTup = ('I', 'am', 'a', 'test', 'tuple')
print(oddTuples(aTup))


"""
 
def applyEachTo(L, x):
    result = []
    for i in range(len(L)):
        result.append(L[i](x))
    return result
    
def square(a):
    return a*a

def halve(a):
    return a/2

def inc(a):
    return a+1


print(applyEachTo([inc, square, halve, abs], -3))









