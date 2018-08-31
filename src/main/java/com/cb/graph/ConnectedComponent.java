
package com.cb.graph;
import com.cb.graph.common.Graph;


public class ConnectedComponent {
    // Class to store information about a vertex in this algorithm
    class CCVertex {
        Graph.Vertex element;
        boolean seen;
        int cno;
        CCVertex(Graph.Vertex u) {
            element = u;
            seen = false;
            cno = -1;
        }
    }
    // Algorithm uses a parallel array for storing information about vertices
    CCVertex[] ccVertex;
    Graph g;

    public ConnectedComponent(Graph g) {
        this.g = g;
        ccVertex = new CCVertex[g.size()];
        for(Graph.Vertex u: g) { ccVertex[u.getName()] = new CCVertex(u); }
    }

    // Main algorithm for finding the number of connected components of g using DFS
    int findCC() {
        int cno = 0;
        for(Graph.Vertex u: g) {
            if(!seen(u)) {
                cno++;
                dfsVisit(u, cno);
            }
        }
        return cno;
    }

    void dfsVisit(Graph.Vertex u, int cno) {
        visit(u, cno);
        for(Graph.Edge e: u) {
            Graph.Vertex v = e.otherEnd(u);
            if(!seen(v)) {
                dfsVisit(v, cno);
            }
        }
    }

    boolean seen(Graph.Vertex u) {
        CCVertex ccu = getCCVertex(u);
        return ccu.seen;
    }

    // Visit a node by marking it as seen and assigning it a component no
    void visit(Graph.Vertex u, int cno) {
        CCVertex ccu = getCCVertex(u);
        ccu.seen = true;
        ccu.cno = cno;
    }

    // From Vertex to CCVertex (ugly)
    CCVertex getCCVertex(Graph.Vertex u) {
        return ccVertex[u.getName()];
    }

    // From CCVertex to Vertex
    Graph.Vertex getVertex(CCVertex c) {
        return c.element;
    }


}
