package iterative.deepening.map;

import java.util.ArrayList;

import iterative.deepening.IDDFS.Graph;
import iterative.deepening.IDDFS.GraphNode;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList;
        Graph graph;
         String[] cities = { "Foz do Iguaçu", "Cascavel", "Pato Branco", "Campo Mourão", "Maringá", "Guarapuava",
                "Londrina", "União da Vitória", "Irati", "Ponta Grossa", "Curitiba" };
        ArrayList<String> identity = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            identity.add(cities[i]);
        }
        int[] peso = { 140, 337, 195, 332, 188, 414, 91, 206, 98, 318, 163, 104, 274, 123, 241, 154, 114 };
        nodeList = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            nodeList.add(new GraphNode(cities[i]));
        }
        graph = new Graph(nodeList);
        graph.addWeightedUndirectedEdge(0, 1, peso[0]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Foz do Iguaçu"), identity.indexOf("Pato Branco"), peso[1]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Cascavel"), identity.indexOf("Campo Mourão"), peso[2]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Cascavel"), identity.indexOf("Guarapuava"), peso[3]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Cascavel"), identity.indexOf("União da Vitória"), peso[4]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Pato Branco"), identity.indexOf("Guarapuava"), peso[5]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Campo Mourão"), identity.indexOf("Maringá"), peso[6]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Campo Mourão"), identity.indexOf("Guarapuava"), peso[7]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Maringá"), identity.indexOf("Londrina"), peso[8]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Guarapuava"), identity.indexOf("Londrina"), peso[9]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Guarapuava"), identity.indexOf("Ponta Grossa"), peso[10]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Guarapuava"), identity.indexOf("Irati"), peso[11]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Londrina"), identity.indexOf("Ponta Grossa"), peso[12]);
        graph.addWeightedUndirectedEdge(identity.indexOf("União da Vitória"), identity.indexOf("Irati"), peso[13]);
        graph.addWeightedUndirectedEdge(identity.indexOf("União da Vitória"), identity.indexOf("Curitiba"), peso[14]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Irati"), identity.indexOf("Curitiba"), peso[15]);
        graph.addWeightedUndirectedEdge(identity.indexOf("Ponta Grossa"), identity.indexOf("Curitiba"), peso[16]);

        graph.depthFirstSearch(0, "União da Vitória".toUpperCase());
        graph.getResult().searchSummary();
        

    }
}
