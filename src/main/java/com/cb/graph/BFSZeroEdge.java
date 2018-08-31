package com.cb.graph;

import com.cb.graph.common.BFS;
import com.cb.graph.common.Graph;

public class BFSZeroEdge extends BFS {

    BFSZeroEdge(Graph g, Graph.Vertex src) {
        super(g, src);
    }

    boolean isSpanningTree() {
        bfs();
        visit(src, src);
        for (Graph.Vertex vertex : graph) {
            if (vertex != null) {
                if (!seen(vertex))
                    return false;
            }
        }
        return true;
    }
}
