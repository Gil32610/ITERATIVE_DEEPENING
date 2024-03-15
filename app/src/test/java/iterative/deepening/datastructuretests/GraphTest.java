package iterative.deepening.datastructuretests;

import iterative.deepening.*;
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
        int[] values ={5,7,13,17,9,18};
        char[] identity = {'A', 'B', 'C','D', 'E', 'F'};
        nodeList = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            nodeList.add(new GraphNode(values[i], identity[i]));
        }
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
