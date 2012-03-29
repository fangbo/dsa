package net.bobo.dsa.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphNode {

    private String name;
    
    private List<GraphNode> adjacentNodes = new LinkedList<GraphNode>();
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void addAdjacent(GraphNode node) {
        this.adjacentNodes.add(node);
        node.adjacentNodes.add(this);
    }
    
    /**
     * �õ���һ���ڽ��
     * 
     * @return
     */
    public GraphNode firstAdjacent() {
        if (adjacentNodes.isEmpty())    return null;
        
        return adjacentNodes.get(0);
    }
    
    /**
     * �õ���һ���ڽڵ㡣
     * 
     * @param previous
     * @return
     */
    public GraphNode nextAdjacent(GraphNode previous) {
        Iterator<GraphNode> nodesItr = adjacentNodes.iterator();
        
        while (nodesItr.hasNext()) {
            if (nodesItr.next() == previous)
                break;
        }
        
        return nodesItr.hasNext() ? nodesItr.next() : null;
    }
}
