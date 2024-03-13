package iterative.deepening;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private Boolean[][] adjacencyMatrix;
    private ArrayList<GraphNode> nodeList;
    private int time;
    private int[] start;
    private int[] finish;
    private Character[] previous;
    

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
         start = new int[nodeList.size()];
         finish = new int[nodeList.size()];
         previous = new Character[nodeList.size()];
        for (int index = 0; index < nodeList.size(); index++) {
            nodeList.get(index).setColor(Color.WHITE);
            start[index] = -2;
            finish[index] = -2;
            previous[index]= null;
        }
        time = -1;
        dfsVisit(s);
        searchResult();
    }
    private void searchResult(){
        System.out.println("DFS result:");
        System.out.println("Time of discover for each node:");
        System.out.println(Arrays.toString(start));
        System.out.println("Time of finish for each node");
        System.out.println(Arrays.toString(finish));
        System.out.println("Parentized Structure: ");
        System.out.println(Arrays.toString(previous));
    }

    private void dfsVisit(int u){
        start[u] = ++time;
        nodeList.get(u).setColor(Color.GRAY);
        for (int v = 0; v < adjacencyMatrix.length; v++) {
            if(adjacencyMatrix[u][v] && nodeList.get(v).getColor().equals(Color.WHITE)){
                previous[v] = nodeList.get(u).getIdentity();
                dfsVisit(v);
            }
        }
        nodeList.get(u).setColor(Color.BLACK);
        finish[u] = ++time;
    }

}
