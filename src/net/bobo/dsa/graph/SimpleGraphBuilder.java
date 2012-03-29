package net.bobo.dsa.graph;

/**
 * input: A-B,C-D,A-C,B-C
 * 
 * @author bo.fangbo
 *
 */
public class SimpleGraphBuilder implements GraphBuilder {

    public Graph build(String input) {
        if (input == null)  throw new IllegalArgumentException("input must not be blank");
        
        Graph g = new Graph();

        String[] edges = input.split(",");
        
        for (String edge : edges) {
            String[] twoNodes = edge.split("-");
            g.addEdeg(twoNodes[0], twoNodes[1]);
        }
        
        return g;
    }

}
