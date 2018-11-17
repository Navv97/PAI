import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        Integer hour = 0;
        String name;
        System.out.println(input.readLine());

        while (true) {
            System.out.println(input.readLine());
            try {
                choice = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Wrong input");
                scanner.close();
                input.close();
                output.close();
                socket.close();
                System.exit(1);
            }
            output.println(choice);
            switch (choice){
                case 1:
                    System.out.println(input.readLine());
                    System.out.println(input.readLine());
                    name = scanner.next();
                    output.println(name);
                    System.out.println(input.readLine());
                    hour = getInteger(socket, input, output, scanner, hour);
                    output.println(hour);
                    System.out.println(input.readLine());
                    System.out.println(input.readLine());
                    break;
                case 2:
                    System.out.println(input.readLine());
                    System.out.println(input.readLine());
                    name = scanner.next();
                    output.println(name);
                    System.out.println(input.readLine());
                    hour = getInteger(socket, input, output, scanner, hour);
                    output.println(hour);
                    System.out.println(input.readLine());
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

    private static Integer getInteger(Socket socket, BufferedReader input, PrintWriter output, Scanner scanner, Integer hour) throws IOException {
        do {
            try {
                hour = scanner.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.close();
                input.close();
                output.close();
                socket.close();
                System.exit(1);
            }
            if(hour > 18 || hour < 10){
                System.out.println("Incorrect hour");
            }
        } while(hour > 18 || hour < 10);
        return hour;
    }
}