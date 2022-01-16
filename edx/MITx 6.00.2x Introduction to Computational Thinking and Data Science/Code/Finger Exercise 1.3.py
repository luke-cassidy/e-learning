# -*- coding: utf-8 -*-
"""
Created on Wed Aug 23 14:05:52 2017

@author: Luke
"""

class Node(object):
    def __init__(self, name):
        self.name = name
    def getName(self):
        return self.name
    def __str__(self):
        return self.name
    
class Edge(object):
    def __init__(self, src, dest):
        self.src = src
        self.dest = dest
    def getSource(self):
        return self.src
    def getDestination(self):
        return self.dest
    def __str__(self):
        return self.src.getName() + '->' + self.dest.getName()
        
class WeightedEdge(Edge):
    def __init__(self, src, dest, weight):
        Edge.__init__(self, src, dest)
        self.weight = weight
    def getWeight(self):
        return self.weight
    def __str__(self):
        return Edge.__str__(self) + " (" + str(self.weight) + ")"
        
class Digraph(object):
    def __init__(self):
        self.edges = {}
        
    def addNode(self, node):
        if node in self.edges:
            raise ValueError("Duplicte Node")
        else:
            self.edges[node] = []
            
    def addEdge(self, edge):
        src = edge.getSource()
        dest = edge.getDestination()
        if not (src in self.edges or src in self.edges):
            raise ValueError("Missing Node")
        else:
            self.edges[src].append(dest)
            
    def childrenOf(self, node):
        return self.edges[node]
        
    def hasNode(self, node):
        return node in self.edges
        
    def getNode(self, name):
        for n in self.edges:
            if n.getName() == name:
                return n
        raise NameError(name)
        
    def __str__(self):
        result = ''
        for src in self.edges:
            for dest in self.edges[src]:
                result += src.getName() + '->' + dest.getName() + '\n'
        return result[:-1] #omit final newline
        
class Graph(Digraph):
    def addEdge(self, edge):
        Digraph.addEdge(self, edge)
        rev = Edge(edge.getDestination(), edge.getSource())
        Digraph.addEdge(self, rev)
        
#def buildCityGraph(graphType):
#    g = graphType()
#    for name in ('Boston','Providence','New York','Chicago','Denver','Phoenix','Los Angeles',):
#        g.addNode(Node(name))
#    g.addEdge(Edge(g.getNode('Boston'), g.getNode('Providence')))
#    g.addEdge(Edge(g.getNode('Boston'), g.getNode('New York')))
#    g.addEdge(Edge(g.getNode('Providence'), g.getNode('Boston')))
#    g.addEdge(Edge(g.getNode('Providence'), g.getNode('New York')))
#    g.addEdge(Edge(g.getNode('New York'), g.getNode('Chicago')))
#    g.addEdge(Edge(g.getNode('Chicago'), g.getNode('Denver')))
#    g.addEdge(Edge(g.getNode('Denver'), g.getNode('Phoenix')))
#    g.addEdge(Edge(g.getNode('Denver'), g.getNode('New York')))
#    g.addEdge(Edge(g.getNode('Chicago'), g.getNode('Phoenix')))
#    g.addEdge(Edge(g.getNode('Los Angeles'), g.getNode('Boston')))
#    return g
#    
#print(buildCityGraph(Graph))
        
def buildStudentGraph(graphType):
    nodes = []
    nodes.append(Node("ABC")) # nodes[0]
    nodes.append(Node("ACB")) # nodes[1]
    nodes.append(Node("BAC")) # nodes[2]
    nodes.append(Node("BCA")) # nodes[3]
    nodes.append(Node("CAB")) # nodes[4]
    nodes.append(Node("CBA")) # nodes[5]

    g = Graph()
    for n in nodes:
        g.addNode(n)
    
#    for i in nodes:
#        for j in nodes[nodes.index(i)+1:]:
#            if (i.getName()[0] == j.getName()[1] and \
#               j.getName()[0] == i.getName()[1]):
#                   g.addEdge(Edge(i, j))
#            if (i.getName()[1] == j.getName()[2] and \
#               j.getName()[1] == i.getName()[2]):
#                   g.addEdge(Edge(i, j))
    g.addEdge(WeightedEdge(nodes[0], nodes[1], 2))
    
    return g

print(buildStudentGraph(Graph))