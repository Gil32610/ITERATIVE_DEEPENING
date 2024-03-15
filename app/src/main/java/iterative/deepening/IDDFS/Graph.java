package iterative.deepening.IDDFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private Edge[][] adjacencyMatrix;
    private ArrayList<GraphNode> nodeList;
    private int time;
    private SearchResult result;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new Edge[nodeList.size()][nodeList.size()];
    }

    public void addWeightedUndirectedEdge(int u, int v, int weight) {
        adjacencyMatrix[v][u] = new Edge(nodeList.get(u),weight);
        adjacencyMatrix[u][v] = new Edge(nodeList.get(v), weight);
    }

    

    public SearchResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("   ");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).getIdentity() + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).getIdentity() + ": ");
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                s.append(flag(adjacencyMatrix[i][j]) + " ");

            }
            s.append("\n");
        }
        return s.toString();

    }

    private String flag(Edge status) {
        return status!=null ? status.getDestination() + "Weight: " + status.getDestination(): "No edge";
    }

    public GraphNode depthFirstSearch(int s, String key) {
         result = new SearchResult(nodeList.size());
         result.setDefaultValues();
        setNotVisited();
        

        GraphNode result = null;

        // iterative deepening goes here
        for (int i = 0; i < adjacencyMatrix.length && result == null; i++) {
            time =  -1;
            result = dfsVisit(s, i, key);
            setNotVisited();
            this.result.setDefaultValues();
        }
        searchResult();
        return result;
    }

    private void setNotVisited() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            nodeList.get(i).setColor(Color.WHITE);
        }
    }

    private void searchResult() {
        System.out.println("DFS result:");
        System.out.println("Time of discover for each node:");
        System.out.println(Arrays.toString(result.getStart()));
        System.out.println("Time of finish for each node");
        System.out.println(Arrays.toString(result.getFinish()));
        System.out.println("Parentized Structure: ");
        System.out.println(Arrays.toString(result.getPrevious()));
    }

    private GraphNode dfsVisit(int u, int maxDepth, String key) {
        GraphNode result = null;
        this.result.setStartTime(u,++time);
        nodeList.get(u).setColor(Color.GRAY);
        if (nodeList.get(u).getIdentity().equals(key)) {
            result = nodeList.get(u);
        }

        if (maxDepth <= 0) {
            return result;
        }
        for (int v = 0; v < adjacencyMatrix.length; v++) {
            if (adjacencyMatrix[u][v]!=null && nodeList.get(v).getColor().equals(Color.WHITE) && result == null) {
                this.result.setPreviousNode(nodeList.get(u).getIdentity(), v);
                result = dfsVisit(v, maxDepth - 1, key);
                if (result != null) {
                    break;
                }
            }
        }
        nodeList.get(u).setColor(Color.BLACK);
        this.result.setFinishTime(u,++time);
        return result;
    }


}
