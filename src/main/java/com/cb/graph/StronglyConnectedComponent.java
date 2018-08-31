package com.cb.graph;


import com.cb.graph.common.Graph;

import java.util.Stack;

public class StronglyConnectedComponent extends ConnectedComponent {
    StronglyConnectedComponent(XGraph g){
        super(g);
    }

    void finishedOrder(XGraph.XVertex v, Stack<Graph.Vertex> St)
    {
        getCCVertex(v).seen=true;
        for(XGraph.Edge t:v.getRevEdgeItr())
            if(!getCCVertex(t.otherEnd(v)).seen)
                finishedOrder((XGraph.XVertex) t.otherEnd(v), St);
        St.push(v);
    }

    int findSSC()
    {
        Stack<Graph.Vertex> stack =new Stack<>();
        for( Graph.Vertex v: g)
            if(!getCCVertex(v).seen)
                finishedOrder((XGraph.XVertex) v, stack);
        for(Graph.Vertex v:g)
            getCCVertex(v).seen=false;
        int count=0;
        while (!stack.empty())
        {
            Graph.Vertex v = stack.peek();
            stack.pop();
            if (!getCCVertex(v).seen) {
                count++;
                dfsVisit(v, count);
            }
        }
        return count;
    }

    public int getComponentNo(Graph.Vertex v) {
        return getCCVertex(v).cno - 1;
    }

}
