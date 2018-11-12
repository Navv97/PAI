import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        System.out.println(input.readLine());

        while (true) {
            String name;
            Integer hour;
            System.out.println(input.readLine());

            int choice = scanner.nextInt();
            output.println(choice);
            switch (choice){
                case 1:
                    System.out.println(input.readLine());
                    name = scanner.next();
                    output.println(name);
                    System.out.println(input.readLine());
                    hour = scanner.nextInt();
                    output.println(hour);
                    break;
                case 2:
                    System.out.println(input.readLine());
                    name = scanner.next();
                    output.println(name);
                    System.out.println(input.readLine());
                    hour = scanner.nextInt();
                    output.println(hour);
                    break;
                case 3:
                    System.out.println(input.readLine());
                    break;
                default:
                    System.out.println(input.readLine());
                    scanner.close();
                    input.close();
                    output.close();
                    socket.close();
                    System.exit(1);
            }
        }
    }
}