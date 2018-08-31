
package com.cb.graph.common;

public class GraphAlgorithm<T> {
    public Graph graph;
    // Algorithm uses a parallel array for storing information about vertices
    protected T[] node;

    public GraphAlgorithm(Graph graph) {
        this.graph = graph;
    }

    protected T getVertex(Graph.Vertex u) {
        return Graph.Vertex.getVertex(node, u);
    }

}
