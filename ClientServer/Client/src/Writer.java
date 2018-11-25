import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Writer extends Thread {
    private Socket clientSocket;
    private PrintWriter output;
    private Scanner scanner = new Scanner(System.in);
    private String clientName;
    private int clientHour;
    private int clientChoice;

    public Writer(Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        this.output = new PrintWriter(this.clientSocket.getOutputStream(), true);
    }

    public void run(){
            try {
                sleep(100);
            } catch (InterruptedException e) {

            }
            System.out.println("Enter name.");
            clientName = scanner.next();
            try {
                do {
                    System.out.println("Enter hour, between 10 and 18.");
                    clientHour = scanner.nextInt();
                } while (clientHour < 10 || clientHour > 18);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for hour.");
                System.exit(1);
            }
            try {
                do {
                    System.out.println("Do you want to: 1. Arrange a visit, 2. Cancel a visit.");
                    clientChoice = scanner.nextInt();
                } while (clientChoice > 2 || clientChoice <= 0);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for choice.");
                System.exit(1);
            }
            output.println(clientName);
            output.println(clientHour);
            output.println(clientChoice);
    }
}
