# -*- coding: utf-8 -*-
"""
Created on Thu Sep 21 17:37:42 2017

@author: Luke
"""

import random
import pylab

class Location(object):
    def __init__(self, x, y):
        self.x = x
        self.y = y
        
    def __str__(self):
        return '<' + str(self.x) + ',' + str(self.y) + '>'
        
    def move(self, deltaX, deltaY):
        return Location(self.x + deltaX, self.y + deltaY)
#        self.x += deltaX
#        self.y += deltaY
#        return self
        
    def getX(self):
        return self.x
        
    def getY(self):
        return self.y
        
    def distFrom(self, other):
        ox = other.getX()
        oy = other.getY()
        xDist = self.x - ox
        yDist = self.y - oy
        return (xDist**2 + yDist**2)**0.5
        
class Field(object):
    def __init__(self):
        self.drunks = {}
        
    def addDrunk(self, drunk, loc):
        if drunk in self.drunks:
            raise ValueError('Duplicate drunk')
        else:
            self.drunks[drunk] = loc
            
    def getLoc(self, drunk):
        if drunk not in self.drunks:
            raise ValueError('Drunk not in field')
        else:
            return self.drunks[drunk]
            
    def moveDrunk(self, drunk):
        if drunk not in self.drunks:
            raise ValueError('Drunk not in field')
        else:
            xDist, yDist = drunk.takeStep()
            currentLocation = self.drunks[drunk]
            self.drunks[drunk] = currentLocation.move(xDist, yDist)

class Drunk(object):
    def __init__(self, name):
        self.name = name
        
    def __str__(self):
        return 'This drunk\'s name is' + self.name 
      
class UsualDrunk(Drunk):
    def __init__(self, name):
        Drunk.__init__(self, name)
        
    def takeStep(self):
        stepChoices = [(0.0,1.0),(0.0,-1.0),(1.0,0.0),(-1.0,0.0)]
        return random.choice(stepChoices)
        
class ColdDrunk(Drunk):
    def __init__(self, name):
        Drunk.__init__(self, name)
        
    def takeStep(self):
        stepChoices = [(0.0,0.9),(0.0,-1.1),(1.0,0.0),(-1.0,0.0)]
        return random.choice(stepChoices)
        
def walk(f, d, numSteps):
    start = f.getLoc(d)
    for s in range(numSteps):
        f.moveDrunk(d)
    return Location.distFrom(start, f.getLoc(d))
    
def simWalks(numSteps, numTrials, dClass):
    Homer = dClass('Homer')
    origin = Location(0,0)
    distances = []
    for t in range(numTrials):
        f = Field()
        f.addDrunk(Homer, origin)
        distances.append(round(walk(f, Homer, numSteps), 1))
    return distances
        
def drunkTest(walklengths, numTrials, dClass):
    for numSteps in walklengths:
        distances = simWalks(numSteps, numTrials, dClass)
        print(dClass.__name__, ' random walk of ', numSteps, ' steps')
        print(' Mean = ', round(sum(distances)/len(distances),4))
        print(' Max = ', max(distances), ' Min = ', min(distances))
        
#drunkTest([10, 100, 1000, 10000], 100, UsualDrunk)
#drunkTest([10, 100, 1000, 10000], 100, ColdDrunk)

class styleIterator(object):
    def __init__(self, styles):
        self.index = 0
        self.styles = styles
        
    def nextStyle(self):
        result = self.styles[self.index]
        if len(self.styles) - self.index == 1:
            self.index = 0
        else:
            self.index += 1         
        return result
        
def simDrunk(walkLengths, numTrials, dClass):
    meanDistances = []
    for numSteps in walkLengths:
        print('Starting simulation of ', numSteps, ' steps')
        trials = simWalks(numSteps, numTrials, dClass)
        mean = sum(trials)/len(trials)
        meanDistances.append(mean)
    return meanDistances
    
def simAll(walklengths, numTrials, drunkKinds):
    styleChoice = styleIterator(('m-', 'b--', 'g-.'))
    pylab.figure()
    pylab.title('Mean Distances from Origin (' + str(numTrials) + ' trials)')
    pylab.xlabel('Number of Steps')
    pylab.ylabel('Mean Distance from Origin')
    pylab.legend(loc = 'best')
        
    for dClass in drunkKinds:
        curStyle = styleChoice.nextStyle()
        print('Starting simulation of ', dClass.__name__ )
        means = simDrunk(walklengths, numTrials, dClass)
        pylab.plot(walklengths, means, curStyle, label = dClass.__name__)
    
#numSteps = (10, 100, 1000, 10000)
#simAll(numSteps, 100, (UsualDrunk, ColdDrunk))

def getFinalLocs(numSteps, numTrials, dClass):
    locs = []
    d = dClass('Homer')
    for t in range(numTrials):
        f = Field()
        f.addDrunk(d, Location(0, 0))
        for s in range(numSteps):
            f.moveDrunk(d)
        locs.append(f.getLoc(d))
    return locs

def plotLocs(drunkKinds, numSteps, numTrials):
    styleChoice = styleIterator(('k+', 'r^', 'mo'))
    for dClass in drunkKinds:
        locs = getFinalLocs(numSteps, numTrials, dClass)
        xVals, yVals = [], []
        for loc in locs:
            xVals.append(loc.getX())
            yVals.append(loc.getY())
        xVals = pylab.array(xVals)
        yVals = pylab.array(yVals)
        meanX = sum(abs(xVals))/len(xVals)
        meanY = sum(abs(yVals))/len(yVals)
        curStyle = styleChoice.nextStyle()
        pylab.plot(xVals, yVals, curStyle,
                      label = dClass.__name__ +\
                      ' mean abs dist = <'
                      + str(meanX) + ', ' + str(meanY) + '>')
    pylab.title('Location at End of Walks ('
                + str(numSteps) + ' steps)')
    pylab.ylim(-1000, 1000)
    pylab.xlim(-1000, 1000)
    pylab.xlabel('Steps East/West of Origin')
    pylab.ylabel('Steps North/South of Origin')
    pylab.legend(loc = 'upper left')

#random.seed(0)
#plotLocs((UsualDrunk, ColdDrunk), 10000, 1000)

class OddField(Field):
    def __init__(self, numHoles = 1000, xRange = 100, yRange = 1000):
        Field.__init__(self)
        self.wormholes = {}
        for w in range(numHoles):
            x = random.randint(-xRange, xRange)
            y = random.randint(-yRange, yRange)
            newX = random.randint(-xRange, xRange)
            newY = random.randint(-yRange, yRange)
            loc = Location(x, y)
            newLoc = Location(newX, newY)
            self.wormholes[loc] = newLoc
            
    def moveDrunk(self, drunk):
        Field.moveDrunk(self, drunk)
        loc = Field.getLoc(self, drunk)
        if loc in self.wormholes:
            self.drunks[drunk] = self.wormholes[loc]
            
#TraceWalk using oddField          
def traceWalk(fieldKinds, numSteps):
    styleChoice = styleIterator(('b+', 'r^', 'ko'))
    for fClass in fieldKinds:
        d = UsualDrunk('Homer')
        f = fClass()
        f.addDrunk(d, Location(0, 0))
        locs = []
        for s in range(numSteps):
            f.moveDrunk(d)
            locs.append(f.getLoc(d))
        xVals, yVals = [], []
        for loc in locs:
            xVals.append(loc.getX())
            yVals.append(loc.getY())
        curStyle = styleChoice.nextStyle()
        pylab.plot(xVals, yVals, curStyle,
                   label = fClass.__name__)
    pylab.title('Spots Visited on Walk ('
                + str(numSteps) + ' steps)')
    pylab.xlabel('Steps East/West of Origin')
    pylab.ylabel('Steps North/South of Origin')
    pylab.legend(loc = 'best')

#random.seed(0)
#traceWalk((Field, OddField), 500)


            
            
            