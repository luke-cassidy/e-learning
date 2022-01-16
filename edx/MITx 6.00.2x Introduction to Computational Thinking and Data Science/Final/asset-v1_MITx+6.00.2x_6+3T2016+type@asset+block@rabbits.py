import random
import pylab

# Global Variables
MAXRABBITPOP = 1000
CURRENTRABBITPOP = 500
CURRENTFOXPOP = 30

def rabbitGrowth():
    """ 
    rabbitGrowth is called once at the beginning of each time step.

    It makes use of the global variables: CURRENTRABBITPOP and MAXRABBITPOP.

    The global variable CURRENTRABBITPOP is modified by this procedure.

    For each rabbit, based on the probabilities in the problem set write-up, 
      a new rabbit may be born.
    Nothing is returned.
    """
    # you need this line for modifying global variables
    global CURRENTRABBITPOP

    births = 0
    for rabbit in range(CURRENTRABBITPOP):
        if random.random() <= (1.0 - CURRENTRABBITPOP/MAXRABBITPOP):
            births += 1
    
    if (CURRENTRABBITPOP + births) < MAXRABBITPOP:
        CURRENTRABBITPOP += births 
    else:
        CURRENTRABBITPOP = MAXRABBITPOP
        
            
def foxGrowth():
    """ 
    foxGrowth is called once at the end of each time step.

    It makes use of the global variables: CURRENTFOXPOP and CURRENTRABBITPOP,
        and both may be modified by this procedure.

    Each fox, based on the probabilities in the problem statement, may eat 
      one rabbit (but only if there are more than 10 rabbits).

    If it eats a rabbit, then with a 1/3 prob it gives birth to a new fox.

    If it does not eat a rabbit, then with a 1/10 prob it dies.

    Nothing is returned.
    """
    # you need these lines for modifying global variables
    global CURRENTRABBITPOP
    global CURRENTFOXPOP

    births = 0
    deaths = 0
    for fox in range(CURRENTFOXPOP):
        if random.random() <= (CURRENTRABBITPOP/MAXRABBITPOP) and CURRENTRABBITPOP > 10:
            CURRENTRABBITPOP -= 1
            if random.random() <= 1/3:
                births += 1
        else:
            if CURRENTFOXPOP > 10:
                if random.random() <= 9/10:
                    deaths += 1
    
    CURRENTFOXPOP += (births - deaths) 

            
def runSimulation(numSteps):
    """
    Runs the simulation for `numSteps` time steps.

    Returns a tuple of two lists: (rabbit_populations, fox_populations)
      where rabbit_populations is a record of the rabbit population at the 
      END of each time step, and fox_populations is a record of the fox population
      at the END of each time step.

    Both lists should be `numSteps` items long.
    """
    rabbitPopulations = []
    foxPopulations = []
    
    for i in range(numSteps):
        rabbitGrowth()
        foxGrowth()
        rabbitPopulations.append(CURRENTRABBITPOP)
        foxPopulations.append(CURRENTFOXPOP)
    
    xAxis = []
    for num in range(numSteps):
        xAxis.append(num)
    
    coeff = pylab.polyfit(range(len(rabbitPopulations)), rabbitPopulations, 2)
    pylab.plot(pylab.polyval(coeff, range(len(rabbitPopulations))))  
    coeff = pylab.polyfit(range(len(foxPopulations)), foxPopulations, 2)
    pylab.plot(pylab.polyval(coeff, range(len(foxPopulations))))
    
    pylab.plot(rabbitPopulations, label = "Rabbit Pop")
    pylab.plot(foxPopulations, label = "Fox Pop")
    pylab.ylabel("Population")
    pylab.xlabel("Time Steps")
    pylab.show()
        
    return (rabbitPopulations, foxPopulations)
        
    
a = runSimulation(200)
x = []
for num in range(200):
    x.append(num)
    
print(pylab.polyfit(a[0], x, 2))
print(pylab.polyfit(a[1], x, 2))
