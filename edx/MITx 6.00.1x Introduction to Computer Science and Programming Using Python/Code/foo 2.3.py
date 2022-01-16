# -*- coding: utf-8 -*-
"""
Created on Fri Sep  9 16:56:01 2016

@author: Luke

"""

import math

def polysum(n, s):
    
    area = (0.25*n*s**2)/(math.tan(math.pi/n))
    perimeter = n * s
    print(area)
    print(perimeter)
    return round(area + perimeter**2,4)
    
x = polysum(3,3)

print(x)
    