public class Shedule {
    private String test = " ";

    public void addVisit(String clientName, Integer hour){
        Server.reservedVisits.put(clientName,hour);
    }

    public void cancelVisit(String clientName, Integer hour){
        Server.reservedVisits.remove(clientName,hour);
    }

    public String getReservedVisits() {
        Server.reservedVisits.forEach((key, value) -> {
//            System.out.println("Hour taken: " + value);
            test = test + " " + value;
        });
        System.out.println(test);
        return test;
    }
}
