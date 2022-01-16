# -*- coding: utf-8 -*-
"""
Created on Sun Dec  3 14:31:02 2017

@author: luke_
"""

def stdDevOfLengths(L):
    """
    L: a list of strings

    returns: float, the standard deviation of the lengths of the strings,
      or NaN if L is empty.
    """
    if len(L) == 0:
        return float("NaN")
    else: 
        wordSum = 0
        for word in L:
            wordSum += len(word)
        mean = wordSum/len(L)
        sumVal  = 0
        for word in L:
            sumVal += (len(word) - mean)**2
        std = (sumVal/len(L))**0.5
        return std