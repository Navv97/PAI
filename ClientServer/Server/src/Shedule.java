import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Shedule {

    public static final ConcurrentHashMap<String,Integer> reservedVisits = new ConcurrentHashMap<>();
    public static final ArrayList<PrintWriter> clientList = new ArrayList<>();
    private static Shedule instance;

    private Shedule(){
    }

    public static Shedule getIstance(){
        if(instance == null){
            synchronized (Shedule.class){
                instance = new Shedule();
            }
        }
        return instance;
    }

    public void addVisit(String clientName, Integer hour){
        reservedVisits.put(clientName,hour);
        for(int i = 0; i < clientList.size(); i++){
            clientList.get(i).println(getReservedVisits());
            clientList.get(i).println("");
        }
//        Iterator iterator = clientList.iterator();
//            while (iterator.hasNext()){
//                PrintWriter writer = (PrintWriter) iterator.next();
//                writer.println(getReservedVisits());
//                writer.flush();
//            }
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

}

