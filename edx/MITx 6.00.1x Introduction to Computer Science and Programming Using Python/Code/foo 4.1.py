# -*- coding: utf-8 -*-
"""
Created on Sat Jul  1 15:52:36 2017

@author: luke_
"""

def integerDivision(x, a):
    """
    x: a non-negative integer argument
    a: a positive integer argument

    returns: integer, the integer division of x divided by a.
    """
    
    count = 0
    
    while x >= a:
        count += 1
        x = x - a
    return count

#print(integerDivision(5, 3))

def f1(n):
   """
   n: integer, n >= 0.
   """
   if n == 0:
      return 1
   else:
      return n * f1(n-1)
      
#print(f1(0))


#def fancy_divide(list_of_numbers, index):
#    try:
#        try:
#            raise Exception("0")
#        finally:
#            denom = list_of_numbers[index]
#            for i in range(len(list_of_numbers)):
#                list_of_numbers[i] /= denom
#    except Exception as ex:
#        print(ex)
        
#fancy_divide([0, 2, 4], 0)
        
        

def fancy_divide(list_of_numbers, index):
   denom = list_of_numbers[index]
   return [simple_divide(item, denom) for item in list_of_numbers]


def simple_divide(item, denom):
    try:
        return item / denom
    except ZeroDivisionError:
        return 0

   
print(fancy_divide([0, 2, 4], 0))