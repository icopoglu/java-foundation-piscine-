import java.io.*;
import java.net.*;

public class CommandCenter{
    public static void main(String[] args) {
    int port = 6_000;
    int deviceCounter = 1;

    try (ServerSocket serverSocket = new ServerSocket(port)){
        System.out.println("===== COMMAND CENTER BAŞLATILDI (Port" + port + ")====");
        System.out.println("Sahadaki cihazlar bekleniyor...");

        while (true){
            Socket clientSocket = serverSocket.accept();

            DeviceHandler task = new DeviceHandler(clientSocket, deviceCounter++);

            Thread worker = new Thread(task);
            worker.start();
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
  }
}