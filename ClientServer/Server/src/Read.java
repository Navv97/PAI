import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Read extends Thread {
    private Socket serverSocket;
    private BufferedReader input;
    private String clientName;
    private Integer clientHour;

    public Read(Socket serverSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.input = new BufferedReader(new InputStreamReader(this.serverSocket.getInputStream()));
    }

    public void run(){
        try{
            clientName = input.readLine();
            clientHour = Integer.parseInt(input.readLine());
            Shedule.getIstance().addVisit(clientName,clientHour);
        }catch (IOException e){

        }
    }
}