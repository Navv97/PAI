import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args)throws IOException{
        ServerSocket serverSocket = new ServerSocket(8888);
        try {
            while (true) {
                new ServerClient(serverSocket.accept());
            }
        }finally {
            serverSocket.close();
        }
    }
}
