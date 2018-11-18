import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Shedule {

    public static final ConcurrentHashMap<String,Integer> reservedVisits = new ConcurrentHashMap<>();
    private final List<PrintWriter> clientList = new ArrayList();
    private static Shedule instance;
    private static boolean listUpdated = false;

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
        notifyClients();
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

    public void notifyClients(){
        for(int i = 0; i < clientList.size(); i++){
            System.out.println("Client id: " + i + " ReservedVisits: " + getReservedVisits() +  "\n");
 //           clientList.get(i).println("");
            clientList.get(i).println(getReservedVisits());
        }
    }

    public void addClient(PrintWriter client){
        this.clientList.add(client);
    }

    public List<PrintWriter> getClientList() {
        return clientList;
    }
}

