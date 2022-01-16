# -*- coding: utf-8 -*-
"""
Created on Fri Sep  9 17:46:21 2016

@author: Luke
"""
"""
balance = 42
annualInterestRate = 0.2
monthlyPaymentRate = 0.04

def creditBalance(balance, annualInterestRate, monthlyPaymentRate, iteration = 0):

    payment = monthlyPaymentRate * balance
    newBalance = (balance - payment)
    newBalance += newBalance * (annualInterestRate/12) 
    
    if iteration >= 12:
        return round(balance,2)
        
    else:
        return creditBalance(round(newBalance,3), annualInterestRate, monthlyPaymentRate, iteration + 1) 

    
    
x = creditBalance(balance, annualInterestRate, monthlyPaymentRate)

print(x)



balance = 4773
annualInterestRate = 0.2

    
def minPayment(balance, annualInterestRate, initBalance, iteration = 0, payment = 10):

    newBalance = (balance - payment)
    newBalance += newBalance * (annualInterestRate/12) 
    
    if iteration >= 11 and newBalance <= 0:
        return payment
    
    elif iteration >= 11 and newBalance >= 0:
        return minPayment(initBalance, annualInterestRate, initBalance, 0, payment + 10)
                
    else:
        return minPayment(newBalance, annualInterestRate, initBalance, iteration + 1, payment) 

    
    
x = minPayment(balance, annualInterestRate, balance)

print(x)



balance = 999999
annualInterestRate = 0.18
upperBound = balance / 12
lowerBound = (balance * (1 + annualInterestRate/12.0)**12) / 12.0
    
    
def minPayment(balance, annualInterestRate, upperBound, lowerBound):
    
    payment = (upperBound + lowerBound)/2
    iteration = 0
    newBalance = balance
    
    while True:
        newBalance = (newBalance - payment)
        newBalance += newBalance * (annualInterestRate/12)
        
        if newBalance >= 0 and iteration <= 12:
            iteration += 1
    
        elif newBalance < 0 and iteration > 12:
            upperBound = payment
            payment = (upperBound + lowerBound)/2
            iteration = 0
            
        elif newBalance > 0 and iteration > 12:
            lowerBound = payment
            payment = (upperBound + lowerBound)/2
            iteration = 0
            
        else:
            return round(payment,2)

    
    
x = minPayment(balance, annualInterestRate, upperBound, lowerBound)
print(x)



balance = 320000
annualInterestRate = 0.2
lowerBound = balance / 12
upperBound = (balance * (1 + annualInterestRate/12.0)**12) / 12.0

    
def minPayment(balance, annualInterestRate, initBalance, iteration, upperBound, lowerBound):

    payment = (upperBound + lowerBound)/2
    newBalance = (balance - payment)
    newBalance += newBalance * (annualInterestRate/12) 
    
    if round(newBalance) >= 0 and iteration <= 10:
        return minPayment(newBalance, annualInterestRate, initBalance, iteration + 1, upperBound, lowerBound) 
        
    elif round(newBalance) < 0 and iteration > 10:
        return minPayment(initBalance, annualInterestRate, initBalance, 0, payment, lowerBound)
            
    elif round(newBalance) > 0 and iteration > 10:
        return minPayment(initBalance, annualInterestRate, initBalance, 0, upperBound, payment)
            
    else:
        return round(payment,2)
    
x = minPayment(balance, annualInterestRate, balance, 0, upperBound, lowerBound)

print(x)

"""
