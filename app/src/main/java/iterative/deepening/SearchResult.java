package iterative.deepening;



public class SearchResult {
    private int[] start;
    private int[] finish;
    private Character[] previous;


    public SearchResult(int size){
        this.start = new int[size];
        this.finish = new int[size];
        this.previous = new Character[size];
    }


    public int[] getStart() {
        return start;
    }


    public int[] getFinish() {
        return finish;
    }


    public Character[] getPrevious() {
        return previous;
    }

    public void setFinishTime(int time){
        this.finish[time]= time;
    }
    
    public void setStartTime(int time){
        this.start[time]= time;
    }

    public void setPreviousNode(char c, int index){
        this.previous[index] = Character.toUpperCase(c);
    }

    public void setDefaultValues(){
        for (int index = 0; index < nodeList.size(); index++) {
            nodeList.get(index).setColor(Color.WHITE);
            start[index] = -2;
            finish[index] = -2;
            previous[index]= null;
        }
    }
}
