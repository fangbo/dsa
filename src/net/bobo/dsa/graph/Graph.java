package net.bobo.dsa.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Graph {

    private Map<String, GraphNode> nodes = new HashMap<String, GraphNode>();
    
    public GraphNode getNode(String name) {
        return nodes.get(name);
    }
    
    public void addEdeg(String node1, String node2) {
        createOrGetNode(node1).addAdjacent(createOrGetNode(node2));
    }
    
    public GraphNode pickNode() {
        int next = new Random().nextInt(nodes.size());
        
        GraphNode node = null;
        
        int i = 0;
        for (Entry<String, GraphNode> entry : this.nodes.entrySet()) {
            if ((i++) == next) {
                node = entry.getValue();
                break;
            }
        }
        
        return node;
    }
    
    public GraphNode createOrGetNode(String name) {
        GraphNode node = getNode(name);
        if (node == null) {
            node = new GraphNode();
            node.setName(name);
            
            this.nodes.put(name, node);
        }
        
        return node;
    }
    
    public boolean nodeExist(String name) {
        return nodes.containsKey(name);
    }
}
