# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

#class Coordinate(object):
#    
#    def __init__(self, x, y):
#        self.x = x
#        self.y = y
#        
#    def __str__(self):
#        return "<" + str(self.x) + "," + str(self.y) + ">"
#        
#    def __sub__(self, other):
#
#        return Coordinate(self.x - other.x, self.y - other.y)
#        
#    def distance(self, other):
#        x_diff_sq = (self.x-other.x)**2
#        y_diff_sq = (self.y-other.y)**2
#        return (x_diff_sq + y_diff_sq)**0.5
#
#
#origin = Coordinate(0, 0)        
#pointA = Coordinate(3, 4)
#pointB = Coordinate(7, 11)
#pointC = Coordinate(2, 5)
#
#print(pointA.distance(origin))
#print(Coordinate.distance(pointA, pointC))
#print(origin)
#print(type(origin))
#print(isinstance(origin, Coordinate))
#print(Coordinate.__sub__(pointA, pointB))


#class Fraction(object):
#    
#    def __init__(self, numer, denom):
#        self.numer = numer
#        self.denom = denom
#        
#    def __str__(self):
#        return str(self.numer) + "/" + str(self.denom)
#        
#    def getNumer(self):
#        return self.numer
#        
#    def getDenom(self):
#        return self.denom
#        
#    def __add__ (self, other):
#        numerNew = other.getDenom() * self.getNumer() + other.getNumer() * self.getDenom()
#        denomNew = other.getDenom() * self.getDenom()
#        return Fraction(numerNew, denomNew)
#        
#    def __sub__(self, other):
#        numerNew = other.getDenom() * self.getNumer() - other.getNumer() * self.getDenom()
#        denomNew = other.getDenom() * self.getDenom()
#        return Fraction(numerNew, denomNew)
#        
#    def convert(self):
#        return self.getNumer() / self.getDenom()
#        
#        
#        
#oneHalf = Fraction(1,2)
#twoThirds = Fraction(2,3)
#
#print(oneHalf)
#print(twoThirds)
#print(oneHalf.getNumer())
#print(Fraction.getDenom(twoThirds))
#
#newFract = oneHalf - twoThirds
#print(newFract)
#print(oneHalf.convert())


#class intSet(object):
#    
#    def __init__(self):
#        self.vals = []
#        
#    def __str__(self):
#        return str(self.vals)
#        
#    def insert(self, other):
#        self.vals.append(other)
#        
#    def remove(self, other):
#        try:
#            self.vals.remove(other)
#        except:
#            print(other, "not in set", sep=" ")
#        
#    def member(self, other):
#        return other in self.vals
#
#            
#aSet = intSet()
#print(aSet)
#print(aSet.member(1))
#aSet.insert(1)
#print(aSet)
#print(aSet.member(1))
#aSet.remove(1)
#aSet.remove(1)
# 
#print(aSet)



#class Coordinate(object):
#    def __init__(self,x,y):
#        self.x = x
#        self.y = y
#
#    def getX(self):
#        # Getter method for a Coordinate object's x coordinate.
#        # Getter methods are better practice than just accessing an attribute directly
#        return self.x
#
#    def getY(self):
#        # Getter method for a Coordinate object's y coordinate
#        return self.y
#
#    def __str__(self):
#        return '<' + str(self.getX()) + ',' + str(self.getY()) + '>'
#
#    def __eq__(self, other):
#        return self.getX() == other.getX() \
#        and self.getY() == other.getY()
#        
#    def __repr__(self):
#        return "Coordinate(" + str(self.x) + "," + str(self.y) + ")"
#        
#c1 = Coordinate(17, 38)
#
#print(repr(c1))


class intSet(object):
    """An intSet is a set of integers
    The value is represented by a list of ints, self.vals.
    Each int in the set occurs in self.vals exactly once."""

    def __init__(self):
        """Create an empty set of integers"""
        self.vals = []

    def insert(self, e):
        """Assumes e is an integer and inserts e into self""" 
        if not e in self.vals:
            self.vals.append(e)

    def member(self, e):
        """Assumes e is an integer
           Returns True if e is in self, and False otherwise"""
        return e in self.vals

    def remove(self, e):
        """Assumes e is an integer and removes e from self
           Raises ValueError if e is not in self"""
        try:
            self.vals.remove(e)
        except:
            raise ValueError(str(e) + ' not found')

    def __str__(self):
        """Returns a string representation of self"""
        self.vals.sort()
        return '{' + ','.join([str(e) for e in self.vals]) + '}'
        
    def intersect(self, other):
        newIntSet = intSet()
        
        for e in self.vals:
            if e in other.vals:
                newIntSet.insert(e)
        return newIntSet
        
    def __len__(self):
        return len(self.vals)
        
        
        
class Animal(object):
    
    def __init__(self, age):
         self.age = age
         self.name = None

    def __str__(self):
        return "aniaml:" + str(self.name) + ":" + str(self.age)
        
    def get_age(self):
        return self.age
        
    def get_name(self):
        return self.name
        
    def set_age(self, newage):
        self.age = newage
        
    def set_name(self, newname=""):
        self.name = newname
   
     
class Cat(Animal):
    
    def speak(self):
        print("meow")
        
    def __str__(self):
        return "Cat:" + str(self.name) + ":" + str(self.age)


class Rabbit(Animal):
    
    def speak(self):
        print("meep")
        
    def __str__(self):
        return "Rabbit:" + str(self.name) + ":" + str(self.age)
        
        
class Person(Animal):
    
    def __init__(self, name, age):
        Animal.__init__(self, age)
        Animal.set_name(self, name)
        self.friends = []
        
    def speak(self):
        print("hello")
        
    def get_friends(self):
        return self.friends
        
    def add_friends(self, fname):
        self.friends.append(fname)
        
    def age_diff(self, other):
        return abs(self.get_age() - other.get_age())
        
    def __str__(self):
        return "Person:" + str(self.name) + ":" + str(self.age)
        
    
class Student(Person):
    
    def __init__(self, name, age, major=None):
        Person.__init__(self, name, age)
        self.major = major
        
    def speak(self):
        print("I am speaking!")
        
    def change_major(self, major):
        self.major = major
        
    def __str__(self):
        return "Student:" + str(self.name) + ":" + str(self.age) + ":" + str(self.major)
        
jelly = Cat(1)
peter = Rabbit(1)
kelly = Person("kelly", 28)
john = Student("barry", 21, "Engineering")
