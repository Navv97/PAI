import java.io.IOException;
import java.net.Socket;

public class ServerClient{
    private Socket serverSocket;
    public Read read;
    public Write write;

    public ServerClient(Socket serverSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.read = new Read(serverSocket);
        read.start();
        this.write = new Write(serverSocket);
        write.start();
    }

}
