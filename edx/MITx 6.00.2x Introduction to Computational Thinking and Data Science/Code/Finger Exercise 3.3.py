# -*- coding: utf-8 -*-
"""
Created on Mon May  7 14:08:52 2018

@author: Luke
"""
import pylab
import numpy

def loadFile():
    inFile = open('julytemps.txt')
    high = []
    low = []
    for line in inFile:
        fields = line.split()
        if len(fields) != 3 or 'Boston' == fields[0] or 'Day' == fields[0]:
            continue
        else:
            high.append(int(fields[1]))
            low.append(int(fields[2]))
    return (low, high)
    
    
diffTemps = list(numpy.array(loadFile()[1]) - numpy.array(loadFile()[0]))

pylab.plot(range(1,32), diffTemps)