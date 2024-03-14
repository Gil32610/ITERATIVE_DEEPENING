package iterative.deepening;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private Boolean[][] adjacencyMatrix;
    private ArrayList<GraphNode> nodeList;
    private int time;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new Boolean[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int u, int v) {
        adjacencyMatrix[v][u] = true;
        adjacencyMatrix[u][v] = true;
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

    private int flag(boolean status) {
        return status ? 1 : 0;
    }

    public void depthFirstSearch(int s) {
        SearchResult result = new SearchResult(nodeList.size());
        result.setDefaultValues();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            nodeList.get(i).setColor(Color.WHITE);
        }
        time = -1;

        dfsVisit(s, result);


        // iterative deepening goes here
        searchResult(result);
    }

    private void searchResult(SearchResult result) {
        System.out.println("DFS result:");
        System.out.println("Time of discover for each node:");
        System.out.println(Arrays.toString(result.getStart()));
        System.out.println("Time of finish for each node");
        System.out.println(Arrays.toString(result.getFinish()));
        System.out.println("Parentized Structure: ");
        System.out.println(Arrays.toString(result.getPrevious()));
    }

    private void dfsVisit(int u, SearchResult result) {
        result.setStartTime(++time);
        nodeList.get(u).setColor(Color.GRAY);
        for (int v = 0; v < adjacencyMatrix.length; v++) {
            if (adjacencyMatrix[u][v] && nodeList.get(v).getColor().equals(Color.WHITE)) {
                result.setPreviousNode(nodeList.get(u).getIdentity(), v);
                dfsVisit(v, result);
            }
        }
        nodeList.get(u).setColor(Color.BLACK);
       result.setFinishTime(++time);
    }

}
