package iterative.deepening.IDDFS;

public class Edge {
    private GraphNode destination;
    private int weight;
    
    public Edge(GraphNode destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public GraphNode getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    


    
    
}
