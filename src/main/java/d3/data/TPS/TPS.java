package d3.data.TPS;

public class TPS {
    
    
    public TPS(String date, long tpsCount) {
        super();
        this.date = date;
        this.tpsCount = tpsCount;
    }
    private String date;
    private long tpsCount;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public long getTpsCount() {
        return tpsCount;
    }
    public void setTpsCount(long tpsCount) {
        this.tpsCount = tpsCount;
    }

}
