package iterative.deepening.IDDFS;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

public class GraphNode {

    private String identity;
    private Color color;

    public GraphNode(int value, String identity){
    
        this.color = Color.WHITE;
        this.identity = identity.toUpperCase();
    }

    public Color getColor() {
        return color;
    }

   

    public String getIdentity() {
        return identity;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof GraphNode){
            GraphNode node = (GraphNode) obj;
            return this.identity == node.identity;
        }else return false;
    }
    

}
