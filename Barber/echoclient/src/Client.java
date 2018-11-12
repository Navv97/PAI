import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        String inputLine;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            inputLine = scanner.nextLine();
            output.println(inputLine);
            String response = input.readLine();
            System.out.println("Server: " + response);
            if(response.equalsIgnoreCase("bye")){
                break;
            }
        }
        scanner.close();
        input.close();
        output.close();
        socket.close();
    }
}