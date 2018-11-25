import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader extends Thread {
    private Socket serverSocket;
    private BufferedReader input;
    private String clientName;
    private Integer clientHour;
    private Shedule shedule;
    private int clientChoice;
    private int clientIndex;

    public Reader(Socket serverSocket) throws IOException{
        this.shedule = Shedule.getIstance();
        this.clientIndex = shedule.getClientListSize() - 1;
        this.serverSocket = serverSocket;
        this.input = new BufferedReader(new InputStreamReader(this.serverSocket.getInputStream()));
    }

    public void run(){
            try {
                clientName = input.readLine();
                clientHour = Integer.parseInt(input.readLine());
                clientChoice = Integer.parseInt(input.readLine());
                System.out.println(clientName + "   " + clientHour + "   " + clientChoice);
                switch (clientChoice) {
                    case 1:
                        shedule.addVisit(clientName, clientHour, this.clientIndex);
                        break;
                    case 2:
                        shedule.cancelVisit(clientName, clientHour, this.clientIndex);
                        break;
                    default:
                        break;
                }
            } catch (IOException e) {

            }
    }
}