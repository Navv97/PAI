import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader extends Thread {
    private Socket clientSocket;
    private BufferedReader input;

    public Reader(Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }

    public void run(){
        try {
            String line;
            while ( (line = input.readLine()) != null) {
//                System.out.println(line);
                try {
                    TrayIconDemo trayIconDemo = new TrayIconDemo(line);
                }catch (AWTException e) {

                }
            }
        }catch (IOException e){

        }
    }

    public class TrayIconDemo {

        public TrayIconDemo(String line) throws AWTException, MalformedURLException {
            if (SystemTray.isSupported()) {
                displayTray(line);
            } else {
                System.err.println("System tray not supported!");
            }
        }

        public void displayTray(String line) throws AWTException, MalformedURLException {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);

            trayIcon.displayMessage("Barber notification", line, MessageType.INFO);
        }
    }
}
