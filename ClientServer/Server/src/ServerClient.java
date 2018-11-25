import java.io.IOException;
import java.net.Socket;

public class ServerClient{
    private Socket serverSocket;
    public Reader read;
    public Writer write;

    public ServerClient(Socket serverSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.write = new Writer(this.serverSocket);
        write.start();
        this.read = new Reader(this.serverSocket);
        read.start();
    }

}
