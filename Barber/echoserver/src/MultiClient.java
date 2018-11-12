import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiClient extends Thread{
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;

    public MultiClient(Socket socket){
        this.clientSocket = socket;
    }

    public void run(){
        try{
            output.println("Witam");
            while (true) {
                output = new PrintWriter(clientSocket.getOutputStream(), true);
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String stringFromInput = input.readLine();
                if (stringFromInput.equalsIgnoreCase("bye")) {
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
