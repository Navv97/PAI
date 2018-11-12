import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static final  ConcurrentHashMap<String,Integer> reservedVisits = new ConcurrentHashMap<>();

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
