import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 5000;
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Client: Sunucuya bağlanıldı -> " + socket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String[] messages = {"Merhaba Server!", "Nasılsın?", "exit"};
            for (String msg : messages) {
                System.out.println("Client: Mesaj gönderiliyor -> " + msg);
                writer.println(msg);

                if("exit".equalsIgnoreCase(msg)) {
                    String response = reader.readLine();
                    System.out.println("Client: Çıkış Yapıldı");
                    break;
                }
                String response = reader.readLine();
                System.out.println("Client: Sunucudan cevap alındı -> " + response);
            }
        }
        catch (ConnectException e) {
            System.err.println("CLIENT HATASI: Server'a ulaşılamadı. Hedef port kapalı olabilir.");
            System.err.println("Detay: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("I/O Hatası: " + e.getMessage());
        }
    }
}