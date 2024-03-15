package iterative.deepening.IDDFS;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

public class GraphNode {

    private String identity;
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

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof GraphNode){
            GraphNode node = (GraphNode) obj;
            return this.value == node.value;
        }else return false;
    }
    

}
