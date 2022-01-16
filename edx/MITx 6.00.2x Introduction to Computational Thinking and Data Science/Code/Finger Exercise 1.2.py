# -*- coding: utf-8 -*-
"""
Created on Sun Aug 20 19:05:57 2017

@author: luke_
"""

class Food(object):
    def __init__(self, n, v, w):
        self.name = n
        self.value = v
        self.calories = w
        
    def getValue(self):
        return self.value
        
    def getCost(self):
        return self.calories
        
    def density(self):
        return self.getValue()/self.getCost()
        
    def __str__(self):
        return self.name + ': <' + str(self.value)\
        + ', ' + str(self.calories) + '>'
        
def buildMenu(names, values, calories):
    menu = []
    for i in range(len(values)):
        menu.append(Food(names[i],values[i],calories[i]))     
    return menu

def greedy(items, maxCost, keyFunction):
    itemsCopy = sorted(items, key = keyFunction, 
                       reverse = True)
    result = []
    totalValue, totalCost = 0.0, 0.0
    for item in itemsCopy: 
        if totalCost + item.getCost() <= maxCost:
            totalCost += item.getCost()
            totalValue += item.getValue()
            result.append(item)            
    return (result, totalValue)
         
def testGreedy(items, maxUnits, keyFunction):
    taken, val = greedy(items, maxUnits, keyFunction)
    print('Total value of items taken =', val)
    for item in taken:
        print(' ', item) 
        
def testGreedys(foods, maxUnits):
    print('Use greedy by value to allocate', maxUnits, 
    'calories')
    testGreedy(foods, maxUnits, Food.getValue)
    print('\nUse greedy by cost to allocate', maxUnits, 
    'calories')
    testGreedy(foods, maxUnits, lambda x: 1/Food.getCost(x))
    print('\nUse greedy by density to allocate', maxUnits, 
    'calories')
    testGreedy(foods, maxUnits, Food.density)
    
def maxVal(toConsider, avail):
    if toConsider == [] or avail == 0:
        result = (0,())
    elif toConsider[0].getCost() > avail:
        result = maxVal(toConsider[1:], avail)
    else:
        thisItem = toConsider[0]
        withVal, withList = maxVal(toConsider[1:], avail-
                                    thisItem.getCost())
        withoutVal, withoutList = maxVal(toConsider[1:], 
                                         avail)
        withVal += thisItem.getValue()
        if withVal > withoutVal:
            result = (withVal, withList + (thisItem,))
        else:
            result = (withoutVal, withoutList)            
    return result

def testMaxVal(items, maxUnits, printItems = True):
    val, taken = maxVal(items, maxUnits)
    print('Total value of items taken =', val)
    if printItems:
        for item in taken:
            print(' ', item)  
        
def testMaxVals(foods, maxUnits):
    print('\nUse search tree to allocate', maxUnits, 
    'calories')
    testMaxVal(foods, maxUnits)

    
names = ['wine', 'beer', 'pizza', 'burger', 'fries',
         'cola', 'apple', 'donut', 'cake']
values = [89, 90, 95, 100, 90, 79, 50, 10]
calories = [123, 154, 258, 354, 365, 150, 95, 195]
foods = buildMenu(names, values, calories)
testGreedys(foods, 750)
testMaxVals(foods, 750)

#import random
#
#class Item(object):
#    def __init__(self, n, v, w):
#        self.name = n
#        self.value = float(v)
#        self.weight = float(w)
#    def getName(self):
#        return self.name
#    def getValue(self):
#        return self.value
#    def getWeight(self):
#        return self.weight
#    def __str__(self):
#        return '<' + self.name + ', ' + str(self.value) +\
#        ', ' + str(self.weight) + '>'
#                     
#def buildItems():
#    return [Item(n,v,w) for n,v,w in (('clock', 175, 10),
#                                      ('painting', 90, 9),
#                                      ('radio', 20, 4),
#                                      ('vase', 50, 2),
#                                      ('book', 10, 1),
#                                      ('computer', 200, 20))]
#                                       
#def buildRandomItems(n):
#    return [Item(str(i),10*random.randint(1,10),random.randint(1,10))
#            for i in range(n)]
#                
#def yieldAllCombos(items):
#    """
#      Generates all combinations of N items into two bags, whereby each 
#      item is in one or zero bags.
#
#      Yields a tuple, (bag1, bag2), where each bag is represented as 
#      a list of which item(s) are in each bag.
#    """
#    N = len(items)
#    # enumerate the 2**N possible combinations
#    for i in range(3**N):
#        bag1 = []
#        bag2 = [] 
#        for j in range(N):
#            # test bit jth of integer i
#            if (i // (3**j)) % 3 == 1:
#                bag1.append(items[j])
#            elif (i // (3**j)) % 3 == 2:
#                bag2.append(items[j])
#        yield (bag1, bag2)
#
#items = buildRandomItems(1)
#combos = yieldAllCombos(items)
#for n in items:
#    print(next(combos))
#
#items = buildItems()
#combos = yieldAllCombos(items)
#for n in items:
#    print(next(combos))

def fastMaxVal(toConsider, avail, memo = {}):
    if toConsider == [] or avail == 0:
        result = (0,())
    elif (len(toConsider), avail) in memo:
        result = memo[(len(toConsider), avail)]
    elif toConsider[0].getCost() > avail:
        result = fastMaxVal(toConsider[1:], avail, memo)
    else:
        thisItem = toConsider[0]
        withVal, withList = fastMaxVal(toConsider[1:], avail-
                                    thisItem.getCost(), memo)
        withoutVal, withoutList = fastMaxVal(toConsider[1:], 
                                         avail, memo)
        withVal += thisItem.getValue()
        if withVal > withoutVal:
            result = (withVal, withList + (thisItem,))
        else:
            result = (withoutVal, withoutList)
        memo[(len(toConsider), avail)] = result
    return result

def testFastMaxVal(items, maxUnits, printItems = True):
    val, taken = fastMaxVal(items, maxUnits)
    print('Total value of items taken =', val)
    if printItems:
        for item in taken:
            print(' ', item)  
        
def testFastMaxVals(foods, maxUnits): 
    print('\nUse search tree to allocate', maxUnits, 
    'calories')
    testFastMaxVal(foods, maxUnits)

    
names = ['wine', 'beer', 'pizza', 'burger', 'fries',
         'cola', 'apple', 'donut', 'cake']
values = [89, 90, 95, 100, 90, 79, 50, 10]
calories = [123, 154, 258, 354, 365, 150, 95, 195]
foods = buildMenu(names, values, calories)
testFastMaxVals(foods, 750)
