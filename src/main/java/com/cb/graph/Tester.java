package com.cb.graph;

import com.cb.graph.common.Graph;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;


public class Tester {
    public static void main(String[] args){

        int noOfVertices = 4;
        Graph g = new Graph(noOfVertices);
        g.setDirected(true);
        System.out.println(g.getVertexArray().length);
        g.addEdge(g.getVertex(1), g.getVertex(2), 4.9, 1);
        g.addEdge(g.getVertex(1), g.getVertex(3), 1.1, 2);
        g.addEdge(g.getVertex(1), g.getVertex(4), 4.6, 3);
        g.addEdge(g.getVertex(3), g.getVertex(1), 1.1, 4);
        g.addEdge(g.getVertex(3), g.getVertex(2), 4.0, 5);
        g.addEdge(g.getVertex(3), g.getVertex(4), 4.3, 6);
        g.addEdge(g.getVertex(2), g.getVertex(4), 2.9, 7);
        g.addEdge(g.getVertex(4), g.getVertex(2), 2.9, 8);

//        g.addEdge(g.getVertex(1), g.getVertex(5), 3.9, 9);
//        g.addEdge(g.getVertex(5), g.getVertex(1), 3.9, 14);
//        g.addEdge(g.getVertex(3), g.getVertex(5), 1, 10);
//        g.addEdge(g.getVertex(5), g.getVertex(3), 1, 15);
//        g.addEdge(g.getVertex(5), g.getVertex(2), 6.9, 11);
//        g.addEdge(g.getVertex(5), g.getVertex(6), 3.7, 12);
//        g.addEdge(g.getVertex(5), g.getVertex(4), 1.9, 13);
//        g.addEdge(g.getVertex(2), g.getVertex(6), 2, 16);
//        g.addEdge(g.getVertex(6), g.getVertex(2), 2, 17);
//        g.addEdge(g.getVertex(4), g.getVertex(6), 1.9, 18);
//        g.addEdge(g.getVertex(6), g.getVertex(4), 1.9, 19);

        printGraph(g);
        Graph.Vertex startVertex = g.getVertex(1);
        List<Graph.Edge> dmst = new ArrayList<>();

        double wmst = directedMST(g, startVertex, dmst);

        System.out.println(wmst);
        System.out.println("_________________________");
        for (Graph.Edge e : dmst) {
            System.out.print(e);
        }
        System.out.println();
        System.out.println("_________________________");



    }

    public void testAnother() {
        //
        double[] pc = {-1.234522,36.89127};
        double[] dr = {-1.224522,36.89727};
        Map<Integer, Order> orders = new HashMap<>();

//        receive a list of orders
        //attach consequtive sequence numbers to orders
        Order order1 = new Order(pc,dr,4.9); //Marsabit Plaza to KNH
        order1.u = 1;
        order1.v = 2;
        Order order2 = new Order(pc,dr, 4.3); //Green House to integrity center
        order2.u = 3;
        order2.v = 4;
        Order order3 = new Order(pc,dr,5.7); //Yaya Center to Hilton
        order3.u = 5;
        order3.v = 6;
        orders.put(1,order1);
        orders.put(2,order2);
//        orders.put(3,order3);

        int noOfVertices = orders.size() * 2;
        Graph g = new Graph(noOfVertices);
        g.setDirected(true);

        Set<Integer> keys = orders.keySet();
        ArrayList<int[]> combinations = new ArrayList<>();
        int arr [] = new int[keys.size()];
        int icmp = 0;
        for (Integer item : keys){
            arr[icmp] = item;
            icmp += 1;
        }
        int r =2;
        int n = arr.length;
        Permutation combinator = new Permutation();
        combinator.generateCombination(combinations,arr,n,r);

        for (int[] cb : combinations) {
            g.addEdge(g.getVertex(orders.get(cb[0]).u),g.getVertex(orders.get(cb[0]).v),orders.get(cb[0]).getOrderDistance());
            g.addEdge(g.getVertex(orders.get(cb[0]).u),g.getVertex(orders.get(cb[1]).v),orders.get(cb[0]).getOrderDistance());
            g.addEdge(g.getVertex(orders.get(cb[0]).u),g.getVertex(orders.get(cb[1]).u),orders.get(cb[0]).getOrderDistance());
            g.addEdge(g.getVertex(orders.get(cb[0]).v),g.getVertex(orders.get(cb[1]).v),orders.get(cb[1]).getOrderDistance());
            g.addEdge(g.getVertex(orders.get(cb[1]).u),g.getVertex(orders.get(cb[0]).v),orders.get(cb[0]).getOrderDistance());
            g.addEdge(g.getVertex(orders.get(cb[1]).u),g.getVertex(orders.get(cb[1]).v),orders.get(cb[0]).getOrderDistance());
            g.addEdge(g.getVertex(orders.get(cb[1]).u),g.getVertex(orders.get(cb[0]).u),orders.get(cb[0]).getOrderDistance());
            g.addEdge(g.getVertex(orders.get(cb[1]).v),g.getVertex(orders.get(cb[0]).v),orders.get(cb[1]).getOrderDistance());
        }
        printGraph(g);
        Graph.Vertex startVertex = g.getVertex(1);
        List<Graph.Edge> dmst = new ArrayList<>();

        double wmst = directedMST(g, startVertex, dmst);

        System.out.println(wmst);
        System.out.println("_________________________");
        for (Graph.Edge e : dmst) {
            System.out.print(e);
        }
        System.out.println();
        System.out.println("_________________________");



    }

    public static double directedMST(Graph g, Graph.Vertex start, List<Graph.Edge> dmst) {
        SpanningTree spanningTree = new SpanningTree(g, start);
        return spanningTree.findSpanningTree(dmst);
    }


    static void printGraph(Graph g) {
        for (Graph.Vertex v : g) {
            for (Graph.Edge e : v) {
                System.out.println(v + " " + e.otherEnd(v) + " " + e.getWeight());
            }
        }
    }


}