import java.util.concurrent.ConcurrentHashMap;

public class Shedule {

    public static final ConcurrentHashMap<String,Integer> reservedVisits = new ConcurrentHashMap<>();
    private static Shedule istance;

    private Shedule(){
    }

    public static Shedule getIstance(){
        if(istance == null){
            synchronized (Shedule.class){
                istance = new Shedule();
            }
        }
        return istance;
    }

    public void addVisit(String clientName, Integer hour){
        reservedVisits.put(clientName,hour);
    }

    public void cancelVisit(String clientName, Integer hour){
        reservedVisits.remove(clientName,hour);
    }

    public String getReservedVisits() {
        StringBuffer stringBuffer = new StringBuffer("Hours taken: ");
        reservedVisits.forEach((key, value) ->
            stringBuffer.append(value + " "));
        return stringBuffer.toString();
    }

    public boolean checkScheduleStatus(int clientValue){
        if(reservedVisits.containsValue(clientValue)) {
            return false;
        } else {
            return true;
        }
    }
}
