import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8888);
        try{
            while(true) {
                new MultiClient(serverSocket.accept()).start();
            }
        } finally {
            serverSocket.close();
        }
    }
}
