package net.bobo.dsa.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {
    
    private Map<Integer, Set<GraphNode>> levelNodes = new HashMap<Integer, Set<GraphNode>>();
    
    private Set<GraphNode> visitedNodes = new HashSet<GraphNode>();
    
    public Map<Integer, Set<GraphNode>> dfs(Graph graph) {
        visit(1, graph.pickNode());
        
        return this.levelNodes;
    }
    
    private void visit(int level, GraphNode node) {
        if (this.visitedNodes.contains(node))   return;
        
        addLevel(level, node);
        this.visitedNodes.add(node);
        
        GraphNode adjacent = node.firstAdjacent();
        while (adjacent != null) {
            visit(level+1, adjacent);
            
            adjacent = node.nextAdjacent(adjacent);
        }
    }
    
    public void addLevel(int level, GraphNode node) {
        Set<GraphNode> sets = levelNodes.get(level);
        if (sets == null) {
            sets = new HashSet<GraphNode>();
            this.levelNodes.put(level, sets);
        }
        
        sets.add(node);
    }

    
    public static void main(String[] args) {
        GraphBuilder builder = new SimpleGraphBuilder();
        Graph g = builder.build("A-B,B-C,C-D,B-D");
        
        Map<Integer, Set<GraphNode>> sets = new DFS().dfs(g);
        
        for (int level : sets.keySet()) {
            System.out.println("==========================");
            System.out.println("level: " + level);
            for (GraphNode node : sets.get(level)) {
                System.out.println(node.getName());
            }
        }
    }
}
