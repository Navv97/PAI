import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Write extends Thread {
    private Socket clientSocket;
    private PrintWriter output;
    private Scanner scanner = new Scanner(System.in);
    private String clientName;
    private int clientHour;

    public Write(Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        this.output = new PrintWriter(this.clientSocket.getOutputStream(), true);
    }

    public void run(){
        clientName = scanner.nextLine();
        output.println(clientName);
        clientHour = scanner.nextInt();
        output.println(clientHour);
    }
}
