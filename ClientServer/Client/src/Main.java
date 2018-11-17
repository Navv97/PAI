import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        Socket clientSocket = new Socket("127.0.0.1", 8888);
        Client client = new Client(clientSocket);
    }
}
