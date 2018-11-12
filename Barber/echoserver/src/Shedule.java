import java.util.concurrent.ConcurrentHashMap;

public class Shedule {
    private ConcurrentHashMap<String,Integer> reservedVisits = new ConcurrentHashMap<>();

    public void addVisit(String clientName, Integer hour){
        reservedVisits.put(clientName,hour);
    }

    public ConcurrentHashMap<String, Integer> getReservedVisits() {
        return reservedVisits;
    }
}
