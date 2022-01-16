# -*- coding: utf-8 -*-
"""
Created on Wed Jul 19 13:10:30 2017

@author: luke_
"""
import pylab as plt

def retire(monthly, rate, terms):
    savings = [0]
    base = [0]
    mRate = rate/12
    for i in range(terms):
        base += [i]
        savings += [savings[-1]*(1 + mRate) + monthly]
    return base, savings
    
def displayRetireWMonthlies(monthlies, rate, terms):
    plt.figure("retireMonth")
    plt.clf()
    for monthly in monthlies:
        xvals, yvals = retire(monthly, rate, terms)
        plt.plot(xvals, yvals, label="retire: " + str(monthly))
        plt.legend(loc = "upper left")

mList = [500, 600, 700, 800, 900, 1000, 1100]        
displayRetireWMonthlies(mList, .05, 40*12)

def displayRetireWRates(month, rates, terms):
    plt.figure("retireRate")
    plt.clf()
    for rate in rates:
        xvals, yvals = retire(month, rate, terms)
        plt.plot(xvals, yvals, label="retire: " + str(month) + ":" + str(int(rate*100)))
        plt.legend(loc = "upper left")
        
rList = [.03, .04, .05, .06, .07]        
displayRetireWRates(800, rList, 40*12)


def displayRetireWMonthsAndRates(monthlies, rates, terms):
    plt.figure("retireBoth")
    plt.clf()
    plt.xlim(30*12, 40*12)
    for monthly in monthlies:
        for rate in rates:
            xvals, yvals = retire(monthly, rate, terms)
            plt.plot(xvals, yvals, label="retire: " + str(monthly) + ":" + str(int(rate*100)))
            plt.legend(loc = "upper left")
            
displayRetireWMonthsAndRates(mList, rList, 40*12)