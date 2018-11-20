import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    public Client(Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        Writer write = new Writer(clientSocket);
        write.start();
        Reader read = new Reader(clientSocket);
        read.start();
    }
}
