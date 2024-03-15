package iterative.deepening.IDDFS;



public class SearchResult {
    private int[] start;
    private int[] finish;
    private String[] previous;
    private int size;

    public SearchResult(int size){
        this.start = new int[size];
        this.finish = new int[size];
        this.previous = new String[size];
        this.size = size;
    }


    public int[] getStart() {
        return start;
    }


    public int[] getFinish() {
        return finish;
    }


    public String[] getPrevious() {
        return previous;
    }

    public void setFinishTime(int time){
        this.finish[time]= time;
    }
    
    public void setStartTime(int time){
        this.start[time]= time;
    }

    public void setPreviousNode(String s, int index){
        this.previous[index] = s.toLowerCase();
    }

    public void setDefaultValues(){
        for (int index = 0; index < size; index++) {
            start[index] = -2;
            finish[index] = -2;
            previous[index]= null;
        }
    }
}
