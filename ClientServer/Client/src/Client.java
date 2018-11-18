import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    public Client(Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        Write write = new Write(clientSocket);
        write.start();
        Read read = new Read(clientSocket);
        read.start();
    }
}
