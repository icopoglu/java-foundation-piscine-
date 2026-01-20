import java.io.*;
import java.net.*;

public class ByteServer {
    public static void main(String[] args) {
        int port = 6_000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server: Port " + port +" dinleniyor... (Beklemede)");

            Socket socket = serverSocket.accept();
            System.out.println("Server: Bağlantı kabul edildi. ->" +socket.getInetAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());

            byte header = in.readByte();
            int unsignedHeader = header & 0xFF;

            System.out.printf("SERVER: Okunan Header: 0x%02X%n", unsignedHeader);

            if(unsignedHeader != 0xAA) {
                System.out.println("SERVER: Geçersiz header alındı. Bağlantı sonlandırılıyor.");
                socket.close();
                return;
            }
            byte command = in.readByte();
            System.out.printf("SERVER: Okunan Komut: 0x%02X%n", command);

            int value = in.readInt();
            System.out.println("SERVER: Okunan Değer: " + value);

        } 
        catch(EOFException e) {
            System.out.println("SERVER: Beklenmedik bağlantı kesilmesi - " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("SERVER: Hata oluştu - " + e.getMessage());
        }
    }
}