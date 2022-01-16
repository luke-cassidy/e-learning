# -*- coding: utf-8 -*-
"""
Created on Wed Jul 19 13:10:30 2017

@author: luke_
"""
import pylab as plt

mySamples = []
myLinear = []
myQuadratic = []
myCubic = []
myExponential = []

for i in range(0, 31):
    mySamples.append(i)
    myLinear.append(i)
    myQuadratic.append(i*i)
    myCubic.append(i*i*i)
    myExponential.append(1.5**i)
    
#plt.figure("lin")
#plt.xlabel("sample points")
#plt.ylabel("linear function")
#plt.ylim(0, 1000)
#plt.plot(mySamples, myLinear)
#plt.figure("quad")
#plt.xlabel("sample points")
#plt.ylabel("quadratic function")
#plt.ylim(0, 1000)
#plt.plot(mySamples, myQuadratic)
#plt.figure("cube")
#plt.xlabel("sample points")
#plt.ylabel("cubic function")
#plt.plot(mySamples, myCubic)
#plt.figure("expo")
#plt.xlabel("sample points")
#plt.ylabel("exponential function")
#plt.plot(mySamples, myExponential)
#
#plt.figure("lin")
#plt.title("Linear Graph")
#
#plt.figure("quad")
#plt.title("Quadratic Graph")
#
#plt.figure("cube")
#plt.title("Cubic Graph")
#
#plt.figure("expo")
#plt.clf()
#plt.plot(mySamples, myExponential)
#plt.title("Exponential Graph")

plt.figure("lin quad")
plt.clf()
plt.subplot(211)
plt.ylim(0, 1000)
plt.plot(mySamples, myLinear, "b-", label = "linear", linewidth = 2.0)
plt.subplot(212)
plt.ylim(0, 1000)
plt.plot(mySamples, myQuadratic, "ro", label = "quadratic", linewidth = 3.0)
plt.title("Linear vs Quadratic")
plt.legend(loc = "upper left")

plt.figure("cube expo")
plt.clf()
plt.subplot(121)
plt.ylim(0, 140000)
plt.plot(mySamples, myCubic, "g^", label = "cubic", linewidth = 4.0)
plt.plot(mySamples, myExponential, "r--", label = "exponential", linewidth = 5.0)

plt.subplot(122)
plt.plot(mySamples, myCubic, "g^", label = "cubic", linewidth = 4.0)
plt.plot(mySamples, myExponential, "r--", label = "exponential", linewidth = 5.0)
plt.yscale("log")
plt.title("Cubic vs Exponential")
plt.legend()
