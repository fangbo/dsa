package net.bobo.dsa.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BFS {

    private Map<Integer, Set<GraphNode>> levelNodes = new HashMap<Integer, Set<GraphNode>>();
    
    private Set<GraphNode> visitedNodes = new HashSet<GraphNode>();
    
    public Map<Integer, Set<GraphNode>> bfs(Graph graph) {
        GraphNode node = graph.pickNode();
        markVisited(1, node);
        
        visit(1, node);
        
        return levelNodes;
    }
    
    public void visit(int level, GraphNode node) {
        boolean needQuit = true;
        GraphNode adjcent = node.firstAdjacent();
        while (adjcent != null) {
            if (!isVisited(adjcent)) {
                needQuit = false;
            }
            
            adjcent = node.nextAdjacent(adjcent);
        }
        
        if (needQuit) return;
        
        adjcent = node.firstAdjacent();
        while (adjcent != null) {
            if (!isVisited(adjcent)) {
                markVisited(level+1, adjcent);
            }
            
            adjcent = node.nextAdjacent(adjcent);
        }

        adjcent = node.firstAdjacent();
        while (adjcent != null) {
            visit(level+1, adjcent);
            
            adjcent = node.nextAdjacent(adjcent);
        }
    }
    
    private void markVisited(int level, GraphNode node) {
        Set<GraphNode> sets = levelNodes.get(level);
        if (sets == null) {
            sets = new HashSet<GraphNode>();
            levelNodes.put(level, sets);
        }
        
        sets.add(node);
        
        visitedNodes.add(node);
    }
    
    private boolean isVisited(GraphNode node) {
        return visitedNodes.contains(node);
    }
    
    public static void main(String[] args) {
        GraphBuilder builder = new SimpleGraphBuilder();
        Graph g = builder.build("A-B,B-C,C-D,B-D,D-E,E-A,F-E");
        
        Map<Integer, Set<GraphNode>> sets = new BFS().bfs(g);
        
        for (int level : sets.keySet()) {
            System.out.println("==========================");
            System.out.println("level: " + level);
            for (GraphNode node : sets.get(level)) {
                System.out.println(node.getName());
            }
        }
    }
}
