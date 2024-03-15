package iterative.deepening.datastructuretests;

import iterative.deepening.*;
import iterative.deepening.IDDFS.Edge;
import iterative.deepening.IDDFS.Graph;
import iterative.deepening.IDDFS.GraphNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GraphTest {
    private ArrayList<GraphNode> nodeList;

    @BeforeEach
    public void setUp() {
        String[] identity = {"Foz do Iguaçu", "Cascavel", "Pato Branco", "Campo Mourão", "Maringá", "Guarapuava", "Londrina", "União da Vitória", "Irati", "Ponta Grossa", "Curitiba"};
        int[] peso = {140, 337, 195, 332, 188, 414, 91, 206, 98, 318, 163, 104, 274, 123, 241, 154, 114};
        nodeList = new ArrayList<>();

        nodeList.add(new GraphNode("Foz do Iguaçu", peso[0], "Cascavel");
        nodeList.add(new GraphNode("Foz do Iguaçu", peso[1], "Pato Branco");
        nodeList.add(new GraphNode("Cascavel", peso[2], "Campo Mourão");
        nodeList.add(new GraphNode("Cascavel", peso[3], "Guarapuava");
        nodeList.add(new GraphNode("Cascavel", peso[4], "União da Vitória");
        nodeList.add(new GraphNode("Pato Branco", peso[5], "Guarapuava");
        nodeList.add(new GraphNode("Campo Mourão", peso[6], "Maringá");
        nodeList.add(new GraphNode("Campo Mourão", peso[7], "Guarapuava");
        nodeList.add(new GraphNode("Maringá", peso[8], "Londrina");
        nodeList.add(new GraphNode("Guarapuava", peso[9], "Londrina");
        nodeList.add(new GraphNode("Guarapuava", peso[10], "Ponta Grossa");
        nodeList.add(new GraphNode("Guarapuava", peso[11], "Irati");
        nodeList.add(new GraphNode("Londrina", peso[12], "Ponta Grossa");
        nodeList.add(new GraphNode("União da Vitória", peso[13], "Irati");
        nodeList.add(new GraphNode("União da Vitória", peso[14], "Curitiba");
        nodeList.add(new GraphNode("Irati", peso[15], "Curitiba");
        nodeList.add(new GraphNode("Ponta Grossa", peso[16], "Curitiba");

        Graph G = new Graph(nodeList);
    }

    @Test
    public void testSimpleGraph() {
        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(4, 5);
    
        GraphNode expected = new GraphNode(13, 'C');
        GraphNode actual = graph.depthFirstSearch(0, 13);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGraphWithCycle() {
        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(2, 0);

        System.out.println("Testing Graph with Cycle:");
        //graph.depthFirstSearch(0);
        System.out.println();
    }

    @Test
    public void testDisconnectedGraph() {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        for (char c = 'A'; c <= 'E'; c++) {
            nodeList.add(new GraphNode(0, c));
        }

        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(2, 3);

        System.out.println("Testing Disconnected Graph:");
        //graph.depthFirstSearch(0);
        System.out.println();
    }
}
