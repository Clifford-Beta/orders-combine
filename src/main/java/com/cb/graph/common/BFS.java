package com.cb.graph.common;

import java.util.Queue;
import java.util.LinkedList;

public class BFS extends GraphAlgorithm<BFS.BFSVertex> {
    public static final int INFINITY = Integer.MAX_VALUE;
    // Class to store information about a vertex in this algorithm
    static class BFSVertex {
        boolean seen;
        Graph.Vertex parent;
        int distance;  // distance of vertex from source
        BFSVertex(Graph.Vertex u) {
            seen = false;
            parent = null;
            distance = INFINITY;
        }
    }

    public Graph.Vertex src;

    public BFS(Graph graph, Graph.Vertex src) {
        super(graph);
        this.src = src;
        node = new BFSVertex[graph.size()];
        // Create array for storing vertex properties
        for(Graph.Vertex u: graph) {
            node[u.getName()] = new BFSVertex(u);
        }
        // Set source to be at distance 0
        getVertex(src).distance = 0;
    }

    // reinitialize allows running BFS many times, with different sources
    void reinitialize(Graph.Vertex newSource) {
        src = newSource;
        for(Graph.Vertex u: graph) {
            BFSVertex bu = getVertex(u);
            bu.seen = false;
            bu.parent = null;
            bu.distance = INFINITY;
        }
        getVertex(src).distance = 0;
    }

   public void bfs() {
        Queue<Graph.Vertex> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            Graph.Vertex u = q.remove();
            for(Graph.Edge e: u) {
                Graph.Vertex v = e.otherEnd(u);
                if(!seen(v)) {
                    visit(u,v);
                    q.add(v);
                }
            }
        }
    }

    public boolean seen(Graph.Vertex u) {
        return getVertex(u).seen;
    }

    public Graph.Vertex getParent(Graph.Vertex u) {
        return getVertex(u).parent;
    }

    // Visit a node v from u
    public void visit(Graph.Vertex u, Graph.Vertex v) {
        BFSVertex bv = getVertex(v);
        bv.seen = true;
        bv.parent = u;
        bv.distance = getVertex(u).distance + 1;
    }
}