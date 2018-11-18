import java.io.IOException;
import java.net.Socket;

public class ServerClient{
    private Socket serverSocket;
    public Read read;
    public Write write;

    public ServerClient(Socket serverSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.write = new Write(this.serverSocket);
        write.start();
        this.read = new Read(this.serverSocket);
        read.start();
    }

}
