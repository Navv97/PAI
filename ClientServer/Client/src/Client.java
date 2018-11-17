import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    public Client(Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        Read read = new Read(clientSocket);
        read.start();
        Write write = new Write(clientSocket);
        write.start();
    }
}
