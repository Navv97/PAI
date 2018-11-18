import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Read extends Thread {
    private Socket clientSocket;
    private BufferedReader input;

    public Read(Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }

    public void run(){
        try {
            System.out.println(input.readLine());
            while ((input.readLine()) != null) {
                System.out.println(input.readLine());
            }
        }catch (IOException e){

        }
    }
}
