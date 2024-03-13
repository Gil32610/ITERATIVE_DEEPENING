package iterative.deepening;

import java.util.ArrayList;

public class Graph {
    private Boolean[][] adjacencyMatrix;
    private ArrayList<GraphNode> nodeList;

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        this.adjacencyMatrix = new Boolean [nodeList.size()][nodeList.size()];
    }
   
    public void addUndirectedEdge(int v, int u){
        adjacencyMatrix[v][u] = true;
        adjacencyMatrix[u][v] = true;
    }

    @Override
    public String toString(){
        StringBuilder s= new StringBuilder();

        s.append("   ");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).getIdentity() + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size() ; i++) {
            s.append(nodeList.get(i).getIdentity()+": ");
            for (int j = 0; j <adjacencyMatrix[i].length ; j++) {
                s.append(flag(adjacencyMatrix[i][j])+ " ");

            }
            s.append("\n");
        }
        return s.toString();

    }
    private int flag(boolean status){
        return status?1:0;
    }


}
