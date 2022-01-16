# -*- coding: utf-8 -*-
"""
Created on Sat Oct  1 19:56:40 2016

@author: luke_
"""
"""
def lyrics_to_frequencies(lyrics):
    myDict = {}
    for word in lyrics:
        if word in myDict:
            myDict[word] += 1
        else:
            myDict[word] = 1
    return myDict
            
            
song = ["this", "is", "a", "song"]

run = lyrics_to_frequencies(song)



def how_many(aDict):

    nValue = 0
    
    for alist in aDict:
        nValue = nValue + len(aDict[alist])

    return nValue



def biggest(aDict):

    maxSize = 0
    
    for nKey in aDict:
        nSize = len(aDict[nKey])
        if nSize >= maxSize:
            maxSize = nSize
            maxList = nKey
            
    return maxList

animals = { 'a': ['aardvark'], 'b': ['baboon'], 'c': ['coati']}

animals['d'] = ['donkey']
animals['d'].append('dog')
animals['d'].append('dingo')

print(animals)
print(how_many(animals))  
print(biggest(animals))


animals = { 'a': ['aardvark'], 'b': ['baboon'], 'c': ['coati']}

animals['d'] = ['donkey']
animals['d'].append('dog')
animals['d'].append('dingo')

def function(aDict):
    '''
    aDict: A dictionary, where all the values are lists.

    returns: int, how many values are in the dictionary.
    '''
    values = aDict.values()
    vList = []
    
    for aList in values:
        vList.append(aList)
        
    count = 0
    
    for aList in vList:
        count += len(aList)

    return count
    
print(function(animals))

"""


def fibonacci(n, d):
    
    if n == 1 or n == 2:
        return 1
    elif n in d:
        return d[n]
    else:
        ans = fibonacci(n-1, d) + fibonacci(n-2, d)
        d[n] = ans
        return ans
    

print(fibonacci(10,{}))