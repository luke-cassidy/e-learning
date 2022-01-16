# -*- coding: utf-8 -*-
"""
Created on Sun May 27 16:48:13 2018

@author: Luke
"""

#import random, pylab
#xVals = []
#yVals = []
#wVals = []
#for i in range(1000):
#    xVals.append(random.random())
#    yVals.append(random.random())
#    wVals.append(random.random())
#xVals = pylab.array(xVals)
#yVals = pylab.array(yVals)
#wVals = pylab.array(wVals)
#xVals = xVals + xVals
#zVals = xVals + yVals
#tVals = xVals + yVals + wVals
#
#pylab.plot(xVals)
##pylab.plot(tVals)
##pylab.plot(xVals, xVals)
#pylab.show()

def drawing_without_replacement_sim(numTrials):
    '''
    Runs numTrials trials of a Monte Carlo simulation
    of drawing 3 balls out of a bucket containing
    4 red and 4 green balls. Balls are not replaced once
    drawn. Returns a float - the fraction of times 3 
    balls of the same color were drawn in the first 3 draws.
    '''
    count = 0
    for i in range(numTrials):
        bucket = ["red","red","red","red","green","green","green","green"]
        chosen = []
        for j in range(3):
            ballIndex = random.randint(0, len(bucket) - 1)
            chosen.append(bucket[ballIndex])
            del bucket[ballIndex]
            
        if (chosen[0] == chosen[1] == chosen[2]):
            count += 1
            
    return count/numTrials
    
##print(drawing_without_replacement_sim(100))

###############################################################################

import random, pylab

# You are given this function
def getMeanAndStd(X):
    mean = sum(X)/float(len(X))
    tot = 0.0
    for x in X:
        tot += (x - mean)**2
    std = (tot/len(X))**0.5
    return mean, std

# You are given this class
class Die(object):
    def __init__(self, valList):
        """ valList is not empty """
        self.possibleVals = valList[:]
    def roll(self):
        return random.choice(self.possibleVals)

# Implement this -- Coding Part 1 of 2
def makeHistogram(values, numBins, xLabel, yLabel, title=None):
    """
      - values, a sequence of numbers
      - numBins, a positive int
      - xLabel, yLabel, title, are strings
      - Produces a histogram of values with numBins bins and the indicated labels
        for the x and y axis
      - If title is provided by caller, puts that title on the figure and otherwise
        does not title the figure
    """
    pylab.hist(values, numBins)
    pylab.xlabel(xLabel)
    pylab.ylabel(yLabel)
    
    if not (title == None):
        pylab.title(title)
        
    pylab.show()
    
                    
# Implement this -- Coding Part 2 of 2
def getAverage(die, numRolls, numTrials):
    """
      - die, a Die
      - numRolls, numTrials, are positive ints
      - Calculates the expected mean value of the longest run of a number
        over numTrials runs of numRolls rolls.
      - Calls makeHistogram to produce a histogram of the longest runs for all
        the trials. There should be 10 bins in the histogram
      - Choose appropriate labels for the x and y axes.
      - Returns the mean calculated
    """      
    longestList = []
    for i in range(numTrials):
        
        rolls = []
        for j in range(numRolls):
            rolls.append(die.roll())
            
        longest = 1
        for x in range(len(rolls) - 1):
            count = 1
            for y in range(x + 1, len(rolls)):
                if rolls[x] == rolls[y]:
                    count += 1
                    if count > longest:
                        longest = count
                else:
                    break
        longestList.append(longest)
        
    makeHistogram(longestList, 10, "Longest Consectutive rolls", "Frequency")          
    return sum(longestList)/numTrials           
    
    
# One test case
#print(makeHistogram([1,2,3,4,5,6], 3, "PEnis", "Gaurdian", "Tile"))
#print(getAverage(Die([1,2,3,4,5,6,6,6,7]), 500, 10000))
#print(getAverage(Die([1]), 10, 10))
#print(getAverage(Die([1,2,3,4,5,6,6,6,7]), 1, 1000))
    
##################################################################################
import numpy as np
    
def find_combination(choices, total):
    """
    choices: a non-empty list of ints
    total: a positive int
 
    Returns result, a numpy.array of length len(choices) 
    such that
        * each element of result is 0 or 1
        * sum(result*choices) == total
        * sum(result) is as small as possible
    In case of ties, returns any result that works.
    If there is no result that gives the exact total, 
    pick the one that gives sum(result*choices) closest 
    to total without going over.
    """
    totalPermutations = 2**len(choices)
    permutations = []
    answer = []
    answerSum = len(choices)
    bestAnswer = []
    bestValue = -1
    
    for permutation in range(totalPermutations): 
        permString = bin(permutation)
        permString = permString.split("b")[1]
        
        for i in range(len(choices) - len(permString)):
            permString = "0" + permString
            
        permString = np.array(list(permString), dtype=int)
        permutations.append(permString)

            
    for permutation in permutations:
        permSum = sum(permutation)
        value = sum(np.multiply(permutation, choices))
        if value == total and permSum <= answerSum:
            answer = permutation
            answerSum = permSum
        elif value < total and (total - value) < (total - bestValue):
            bestAnswer = permutation
            bestValue = value
            
    if answer == []:
        return bestAnswer
    else:
        return answer

       
#print(find_combination([1,2,2,3], 4))
#print(find_combination([1,1,3,5,3], 5))
#print(find_combination([1,1,1,9], 4))
print(find_combination([10, 100, 1000, 3, 8, 12, 38], 1171))