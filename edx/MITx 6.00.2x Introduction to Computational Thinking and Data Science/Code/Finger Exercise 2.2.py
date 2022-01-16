# -*- coding: utf-8 -*-
"""
Created on Fri Aug 25 23:54:11 2017

@author: Luke
"""

import random
def genEven():
    '''
    Returns a random even number x, where 0 <= x < 100
    '''
    numbers = []
    for number in range(0, 100, 2):
        numbers.append(number)
    return random.choice(numbers)


def stochasticNumber():
    '''
    Stochastically generates and returns a uniformly distributed even number between 9 and 21
    '''
    numbers = []
    for number in range(5, 11):
        numbers.append(number)
    return random.choice(numbers)*2
 
print(genEven())   
print(stochasticNumber())

def dist3():
    return int(random.random() * 10)

def dist4():
    return random.randrange(0, 10)

def dist6():
    return random.randint(0, 10)
    
print(dist3())
print(dist4())
print(dist6())