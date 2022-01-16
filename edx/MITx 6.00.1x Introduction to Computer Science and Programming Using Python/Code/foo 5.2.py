# -*- coding: utf-8 -*-
"""
Created on Tue Jul 11 17:29:05 2017

@author: luke_
"""
import datetime

class Person(object):
    
    def __init__(self, name):
        self.name = name
        self.birthday = None
        self.lastName = name.split(" ")[-1]
        
    def getLastName(self):
        return self.lastName
        
    def __str__(self):
        return self.name
        
    def setBirthday(self, day, month, year):
        self.birthday = datetime.date(year, month, day)
        
    def getAge(self):
        return (datetime.date.today() - self.birthday)
        
    def __lt__(self, other):
        if self.lastName == other.lastName:
            return self.name < other.name
        return self.lastName < other.lastName
        

class MITPerson(Person):
    nextIdNum = 0

    def __init__(self, name):
        Person.__init__(self, name)
        self.IdNum = MITPerson.nextIdNum
        MITPerson.nextIdNum += 1
        
    def getIdNum(self):
        return self.IdNum
        
    def __lt__(self, other):
        return self.IdNum < other.IdNum
        
    def speak(self, utterance):
        return (self.getLastName() + " says: " + utterance)
        
class Student(MITPerson):    
    pass


class UG(Student):
    
    def __init__(self, name, classYear):
        MITPerson.__init__(self, name)
        self.year = classYear
        
    def speak(self, utterance):
        MITPerson.speak(self, "Dude, " + utterance)
        
class Grad(Student):    
    pass

class TransferStudent(Student):    
    pass


class Professor(MITPerson):
    
    def __init__(self, name, department):
        MITPerson.__init__(self, name)
        self.department = department
        
    def speak(self, utterance):     
        MITPerson.speak(self, "In course " + self.department + " we say " + utterance)
        
    def lecture(self, topic):
        return self.speak("it is obvious that " + topic)


def isStudent(obj):
    return isinstance(obj, Student)
    


class Grades(object):
    
    def __init__(self):
        self.students = []
        self.grades = {}
        self.isSorted = True
        
    def addStudents(self, student):
        self.students.append(student)
        self.grades[student.getIdNum()] = []
        self.isSorted = False
        
    def addGrades(self, student, grade):
        try:
            self.grades[student.getIdNum].append(grade)
        except KeyError:
            raise ValueError("Student not in grade book")
            
    def getGrades(self, student):
        try:
            return self.grades[student.getIdNum()][:] #[:] == .copy()
        except KeyError:
            raise ValueError("Student not in grade book") 
        
    def allStudents(self):
        if self.isSorted == False:
            self.students.sort()
            self.isSorted == True            
        return self.students[:]
        
        
def genPrimes():
    
    inc = 2
    num = 2
    
    while True:
        prime = True

        while inc < num:
            if num % inc == 0:
                num += 1
                inc = 2
                prime = False
                break
        
            else:
                inc += 1
            
        if prime == True:
            yield num
            num += 1
            inc = 2
        

foo = genPrimes()

for n in range(5):
    print(foo.__next__())
