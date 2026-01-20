import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server: Port " + port +" dinleniyor... (Beklemede)");

            Socket socket = serverSocket.accept();
            System.out.println("Server: Bağlantı kabul edildi. ->" +socket.getInetAddress());
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Server: Mesaj alındı -> " + message);
                if("Merhaba Server!".equalsIgnoreCase(message)) {
                    System.out.println("Server: Mesaj gönderiliyor -> Merhaba Client!");
                    writer.println("Merhaba Client!");
                }
                
                else if("Nasılsın?".equalsIgnoreCase(message)) {
                    System.out.println("Server: Mesaj gönderiliyor -> İyiyim, teşekkürler!");
                    writer.println("İyiyim, teşekkürler!");
                }

                else if("exit".equalsIgnoreCase(message)) {
                    System.out.println("Server: Çıkış komutu alındı. Bağlantı sonlandırılıyor.");
                    writer.println("Server: Bağlantı sonlandırılıyor.");
                    break;
                }
                else {
                    System.out.println("Server: Bilinmeyen komut alındı.");
                    writer.println("Bilinmeyen komut: " + message);
                }
            }

        }
        catch (IOException e) {
            System.out.println("Server: Hata oluştu: " + e.getMessage());
        }
    }
}