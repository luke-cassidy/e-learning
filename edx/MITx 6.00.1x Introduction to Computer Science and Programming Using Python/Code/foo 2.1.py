# -*- coding: utf-8 -*-
"""
Created on Wed Sep  7 19:42:02 2016

@author: Luke
"""
"""
iteration = 0
while iteration < 5:
    count = 0
    for letter in "hello, world":
        count += 1
        if iteration % 2 == 0:
            break
    print("Iteration " + str(iteration) + "; count is: " + str(count))
    iteration += 1 
    

  
cube = 29
guess = 0.0
epsilon = 0.01
iteration = 0.01
numGuesses = 0
    
while abs((guess**3) - cube) >= epsilon and guess <= cube:
    guess += iteration
    numGuesses += 1

print("Number of Guesses: " + str(numGuesses))
    
if abs((guess**3) - cube) >= epsilon:
    print("Failed to find cube root of: " + str(cube))
else:
    print("Cube root of " + str(cube) + " is " + str(guess))

    """
"""
    
x = 25
epsilon = 0.01
step = 0.1
guess = 0.0

while abs(guess**2-x) >= epsilon:
    if guess <= x:
        guess += step
    else:
        break

if abs(guess**2 - x) >= epsilon:
    print('failed')
else:
    print('succeeded: ' + str(guess))
    
"""
"""  
    
x = 54
epsilon = 0.01
numGuesses = 0
low = 1.0
high = x
ans = (high + low)/2

while abs(ans**3 - x) >= epsilon:
    numGuesses += 1
    if ans**3 < x:
        low = ans
    else:
        high = ans
    ans = (high + low)/2
    
print(numGuesses)
print(ans)
    
"""
    
"""

low = 0.0
high = 100
ans = int((high + low)/2)
check = 0

print("Please think of a number between 0 and 100! ")

while True:
    
    print("Is your secret number ", ans, "?")
    check = input("Enter 'h' to indicate the guess is too high. Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly. ")
    
    if check == "l":
        low = ans
        ans = int((high + low)/2)
    elif check == "h":
        high = ans
        ans = int((high + low)/2)
    elif check == "c":
        break
    else:
        check = print("Sorry, I did not understand your input.")
        
print("Game over. Your secret number was: ", ans)

""" 

low = 0.0
high = 100
ans = int((high + low)/2)
check = 0

print("Please think of a number between 0 and 100! ")

while True:
    
    print("Is your secret number ", ans, "?")
    check = input("Enter 'h' to indicate the guess is too high. Enter 'l' to indicate the guess is too low. Enter 'c' to indicate I guessed correctly. ")
    
    if check == "l":
        low = ans
        ans = int((high + low)/2)
    elif check == "h":
        high = ans
        ans = int((high + low)/2)
    elif check == "c":
        break
    else:
        check = print("Sorry, I did not understand your input.")
        
print("Game over. Your secret number was: ", ans)

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
