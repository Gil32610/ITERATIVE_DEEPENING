package iterative.deepening;

import java.util.ArrayList;

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
        int[] start = new int[nodeList.size()];
        int[] finish = new int[nodeList.size()];
        Character[] previous = new Character[nodeList.size()];
        for (int index = 0; index < nodeList.size(); index++) {
            nodeList.get(index).setColor(Color.WHITE);
            start[index] = -2;
            finish[index] = -2;
            previous[index]= null;
        }
        time = -1;
    }

}
