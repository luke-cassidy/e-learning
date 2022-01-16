# -*- coding: utf-8 -*-
"""
Created on Tue Jul 18 12:06:58 2017

@author: luke_
"""

def search(L, e):
    for i in range(len(L)):
        if L[i] == e:
            return True
        if L[i] > e:
            return False
    return False
    
    
def newsearch(L, e):
    size = len(L)
    for i in range(size):
        if L[size-i-1] == e:
            return True
        if L[i] < e:
            return False
    return False
    
L1 = [1, 2, 3, 4, 5, 6, 7]
L2 = [1, 2]
L3 = [1]
L4 = []

print(search(L3, 1))
print(newsearch(L3, 1))


def swapSort(L): 
    """ L is a list on integers """
    print("Original L: ", L)
    for i in range(len(L)):
        for j in range(i+1, len(L)):
            if L[j] < L[i]:
                # the next line is a short 
                # form for swap L[i] and L[j]
                L[j], L[i] = L[i], L[j] 
                print(L)
    print("Final L: ", L)


L5 = [1, 9, 6, 4, 7, 14, 7]
    
print(swapSort(L5))

def modSwapSort(L): 
    """ L is a list on integers """
    print("Original L: ", L)
    for i in range(len(L)):
        for j in range(len(L)):
            if L[j] < L[i]:
                # the next line is a short 
                # form for swap L[i] and L[j]
                L[j], L[i] = L[i], L[j] 
                print(L)
    print("Final L: ", L)
    
L1 = [1, 2, 3, 4, 5, 6, 7]
L2 = [1, 2]
L3 = [1]
L4 = []    
L5 = [1, 9, 6, 4, 7, 14, 7]
    
print(modSwapSort(L5))
    