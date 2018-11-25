import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiClient extends Thread{
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;
    private Shedule shedule = Shedule.getIstance();

    public MultiClient(Socket socket){
        this.clientSocket = socket;
    }

    public void run(){
        try{
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            output.println("Welcome to the barber shop!");
            while (true) {
                output = new PrintWriter(clientSocket.getOutputStream(), true);
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                output.println("How may I help you? 1.Shedule a visit, 2.Cancel a visit, 3.Check availability.");

                String clientChoice = input.readLine();
                Integer parseClientChoice = Integer.parseInt(clientChoice);
                System.out.println(parseClientChoice);

                String clientName;
                String hour;
                Integer parseHour;

                switch (parseClientChoice){
                    case 1:
                        output.println(shedule.getReservedVisits());
                        output.println("Enter your name.");
                        clientName = input.readLine();
                        output.println("Enter hour, between 10 - 18.");
                        hour = input.readLine();
                        parseHour = Integer.parseInt(hour);
                        if (shedule.checkScheduleStatus(parseHour)) {
                            shedule.addVisit(clientName, parseHour);
                            output.println("Visit set");
                        } else {
                            output.println("Visit not set");
                        }
                        output.println(shedule.getReservedVisits());
                        break;
                    case 2:
                        output.println(shedule.getReservedVisits());
                        output.println("Enter your name.");
                        clientName = input.readLine();
                        output.println("Enter hour, between 10 - 18.");
                        hour = input.readLine();
                        parseHour = Integer.parseInt(hour);
                        shedule.cancelVisit(clientName,parseHour);
                        output.println(shedule.getReservedVisits());
                        break;
                    case 3:
                        output.println(shedule.getReservedVisits());
                        break;
                    default:
                        output.println("Bye");
                        break;
                }

                if (parseClientChoice > 3 || parseClientChoice <= 0) {
                    input.close();
                    output.close();
                    break;
                }
            }
        } catch (IOException e){
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e){
            }
        }

    }
}
