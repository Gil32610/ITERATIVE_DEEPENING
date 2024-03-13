package iterative.deepening;

public class GraphNode {

    private Character identity;
    private Color color;
    private int value;

    public GraphNode(int value, char identity){
        this.value = value;
        this.color = Color.WHITE;
        this.identity = Character.toUpperCase(identity);
    }

    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public Character getIdentity() {
        return identity;
    }

    

    

}
