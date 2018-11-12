public class Shedule {

    public void addVisit(String clientName, Integer hour){
        Server.reservedVisits.put(clientName,hour);
    }

    public void cancelVisit(String clientName, Integer hour){
        Server.reservedVisits.remove(clientName,hour);
    }

    public String getReservedVisits() {
        StringBuffer stringBuffer = new StringBuffer("Hour taken: ");
        Server.reservedVisits.forEach((key, value) ->
            stringBuffer.append(value + " "));
        return stringBuffer.toString();
    }
}
