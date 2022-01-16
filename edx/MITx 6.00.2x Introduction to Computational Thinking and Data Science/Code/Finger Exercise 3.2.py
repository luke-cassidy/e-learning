# -*- coding: utf-8 -*-
"""
Created on Mon Dec  4 21:32:55 2017

@author: luke_
"""
import random

def chooseBall(ballBagLol):
    return random.choice(ballBagLol)


def runTrail():
    ballBagLol = ["red", "red", "red", "green", "green", "green"]
    chosenBalls = []

    for num in range(3):
        chosenBall = chooseBall(ballBagLol)
        ballBagLol.remove(chosenBall)
        chosenBalls.append(chosenBall)
        
    if (chosenBalls[0] == chosenBalls[1]) and (chosenBalls[1] == chosenBalls[2]):
        return True
    else:
        return False 
            
    
def noReplacementSimulation(numTrials):
    '''
    Runs numTrials trials of a Monte Carlo simulation
    of drawing 3 balls out of a bucket containing
    3 red and 3 green balls. Balls are not replaced once
    drawn. Returns the a decimal - the fraction of times 3 
    balls of the same color were drawn.
    '''
    success = 0
    
    for num in range(numTrials):
        if runTrail() == True:
            success += 1

    return success/numTrials
    
print(noReplacementSimulation(100000))


def oneTrial():
    '''
    Simulates one trial of drawing 3 balls out of a bucket containing
    3 red and 3 green balls. Balls are not replaced once
    drawn. Returns True if all three balls are the same color,
    False otherwise.
    '''
    balls = ['r', 'r', 'r', 'g', 'g', 'g']
    chosenBalls = []
    for t in range(3):
        # For three trials, pick a ball
        ball = random.choice(balls)
        # Remove the chosen ball from the set of balls
        balls.remove(ball)
        # and add it to a list of balls we picked
        chosenBalls.append(ball)
    # If the first ball is the same as the second AND the second is the same as the third,
    #  we know all three must be the same color.
    if chosenBalls[0] == chosenBalls[1] and chosenBalls[1] == chosenBalls[2]:
        return True
    return False

def noReplacementSimulation(numTrials):
    '''
    Runs numTrials trials of a Monte Carlo simulation
    of drawing 3 balls out of a bucket containing
    3 red and 3 green balls. Balls are not replaced once
    drawn. Returns the a decimal - the fraction of times 3 
    balls of the same color were drawn.
    '''
    numTrue = 0
    for trial in range(numTrials):
        if oneTrial():
            numTrue += 1

    return float(numTrue)/float(numTrials)