import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Write extends Thread {
    private Socket serverSocket;
    private PrintWriter output;

    public Write(Socket serverSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.output = new PrintWriter(this.serverSocket.getOutputStream(), true);
        Shedule.clientList.add(output);
    }

    public void run(){
        output.println(Shedule.getIstance().getReservedVisits());
        Shedule.getIstance().notifyClients();
    }
}
