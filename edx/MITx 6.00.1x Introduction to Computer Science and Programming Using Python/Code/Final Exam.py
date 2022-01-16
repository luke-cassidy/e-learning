# -*- coding: utf-8 -*-
"""
Created on Sat Jul 29 14:11:43 2017

@author: luke_
"""

#L = [1,2,3]
#
#print(type(L))
#
#
#def sum_digits(s):
#    """ assumes s a string
#        Returns an int that is the sum of all of the digits in s.
#          If there are no digits in s it raises a ValueError exception.
#    """
#    answer = 0
#    flag = False
#    for char in s:
#        if char in "0123456789":
#            flag = True
#            answer += int(char)
#        
#    if flag == False:
#        raise ValueError
#    else:
#        return answer
#        
#s = "0"
#print(sum_digits(s))
#
#
#def max_val(t, maxNum = 0): 
#    """ t, tuple or list
#        Each element of t is either an int, a tuple, or a list
#        No tuple or list is empty
#        Returns the maximum int in t or (recursively) in an element of t """ 
#    for el in t:
#        if type(el) == int:
#            if el > maxNum:
#                maxNum = el
#        else:
#            if max_val(el, maxNum) > maxNum:
#                maxNum = max_val(el, maxNum) 
#            
#    return maxNum
#        
#t1 = (5, (1,2), [[1],[2]])
#t2 = (5, (1,2), [[1],[9]])
#print(max_val(t2))
#
#def cipher(map_from, map_to, code):
#    """ map_from, map_to: strings where each contain 
#                          N unique lowercase letters. 
#        code: string (assume it only contains letters also in map_from)
#        Returns a tuple of (key_code, decoded).
#        key_code is a dictionary with N keys mapping str to str where 
#        each key is a letter in map_from at index i and the corresponding 
#        value is the letter in map_to at index i. 
#        decoded is a string that contains the decoded version 
#        of code using the key_code mapping. 
#        """
#    key_code = {}
#    for letter in map_from:
#        key_code[letter] = map_to[map_from.index(letter)]
#    
#    decoded = ""
#    for letter in code:
#        decoded += key_code[letter]
#        
#    return key_code, decoded
#        
#print(cipher("abcd", "dcba", "dab"))


#class Container(object):
#    """ Holds hashable objects. Objects may occur 0 or more times """
#    def __init__(self):
#        """ Creates a new container with no objects in it. I.e., any object 
#            occurs 0 times in self. """
#        self.vals = {}
#    def insert(self, e):
#        """ assumes e is hashable
#            Increases the number times e occurs in self by 1. """
#        try:
#            self.vals[e] += 1
#        except:
#            self.vals[e] = 1
#    def __str__(self):
#        s = ""
#        for i in sorted(self.vals.keys()):
#            if self.vals[i] != 0:
#                s += str(i)+":"+str(self.vals[i])+"\n"
#        return s
#        
#
#class Bag(Container):
#    def remove(self, e):
#        """ assumes e is hashable
#            If e occurs in self, reduces the number of 
#            times it occurs in self by 1. Otherwise does nothing. """
#        try:
#            self.vals[e] -= 1
#        except:
#            self.vals[e] = 0
#
#    def count(self, e):
#        """ assumes e is hashable
#            Returns the number of times e occurs in self. """
#        try:
#            return self.vals[e]
#        except:
#            return 0
#            
#    def __add__(self, other):
#        newBag = Bag()
#        for key in self.vals:
#            for i in range(self.vals[key]):
#                newBag.insert(key)                
#        for key in other.vals:
#            for i in range(other.vals[key]):
#                newBag.insert(key)
#        return newBag
#        
#
#class ASet(Container):
#    def remove(self, e):
#        """assumes e is hashable
#           removes e from self"""
#        try:
#            del(self.vals[e])
#        except:
#            pass
#
#
#    def is_in(self, e):
#        """assumes e is hashable
#           returns True if e has been inserted in self and
#           not subsequently removed, and False otherwise."""
#        if e in self.vals:
#            return True
#        else:
#            return False
#
#
##d1 = Bag()
##d1.insert(4)
##d1.insert(4)
##print(d1)
##d1.remove(2)
##print(d1)
##
##d2 = Bag()
##d2.insert(4)
##d2.insert(4)
##d2.insert(4)
##print(d2.count(2))
##print(d2.count(4))
##
##a = Bag()
##a.insert(4)
##a.insert(3)
##b = Bag()
##b.insert(4)
##print(a+b)
#
#d1 = ASet()
#d1.insert(4)
#d1.insert(4)
#
#d1.remove(2)
#print(d1)
#
#d1.remove(4)
#print(d1)
#
#d1 = ASet()
#d1.insert(4)
#print(d1.is_in(4))
#d1.insert(5)
#print(d1.is_in(5))
#d1.remove(5)
#print(d1.is_in(5))


### Do not change the Location or Campus classes. ###
### Location class is the same as in lecture.     ###
class Location(object):
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def move(self, deltaX, deltaY):
        return Location(self.x + deltaX, self.y + deltaY)
    def getX(self):
        return self.x
    def getY(self):
        return self.y
    def dist_from(self, other):
        xDist = self.x - other.x
        yDist = self.y - other.y
        return (xDist**2 + yDist**2)**0.5
    def __eq__(self, other):
        return (self.x == other.x and self.y == other.y)
    def __str__(self):
        return '<' + str(self.x) + ',' + str(self.y) + '>'
        
class Campus(object):
    def __init__(self, center_loc):
        self.center_loc = center_loc
    def __str__(self):
        return str(self.center_loc)
        
        
class MITCampus(Campus):
    """ A MITCampus is a Campus that contains tents """
    def __init__(self, center_loc, tent_loc = Location(0,0)):
        """ Assumes center_loc and tent_loc are Location objects 
        Initializes a new Campus centered at location center_loc 
        with a tent at location tent_loc """
        Campus.__init__(self, center_loc)
        self.tents = [] 
        self.tents.append(tent_loc)
      
    def add_tent(self, new_tent_loc):
        """ Assumes new_tent_loc is a Location
        Adds new_tent_loc to the campus only if the tent is at least 0.5 distance 
        away from all other tents already there. Campus is unchanged otherwise.
        Returns True if it could add the tent, False otherwise. """
        for tent in self.tents:
            if Location.dist_from(tent, new_tent_loc) < 0.5:
                return False
        self.tents.append(new_tent_loc)
        return True
      
    def remove_tent(self, tent_loc):
        """ Assumes tent_loc is a Location
        Removes tent_loc from the campus. 
        Raises a ValueError if there is not a tent at tent_loc.
        Does not return anything """
        try:
            self.tents.remove(tent_loc)
        except:
            raise ValueError
                
    def get_tents(self):
        """ Returns a list of all tents on the campus. The list should contain 
        the string representation of the Location of a tent. The list should 
        be sorted by the x coordinate of the location. """
        tents = []
        for tent in self.tents:
            tents.append(tent.__str__())
        return sorted(tents)
        
c = MITCampus(Location(1,2))

print(c.add_tent(Location(2,3)))
print(c.add_tent(Location(1,2)))
print(c.add_tent(Location(0,0)))
print(c.add_tent(Location(2,3)))
print(c.get_tents())