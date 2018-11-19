import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Write extends Thread {
    private Socket serverSocket;
    private PrintWriter output;
    private Shedule shedule;
    private int clientIndex;

    public Write(Socket serverSocket) throws IOException{
        this.shedule = Shedule.getIstance();
        this.serverSocket = serverSocket;
        this.output = new PrintWriter(this.serverSocket.getOutputStream(), true);
        shedule.addClient(output);
    }

    public void run(){
        output.println(shedule.getReservedVisits());
    }
}
