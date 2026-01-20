import java.io.*;
import java.net.*;

public class EndianServer {
    public static void main(String[] args) {
        int port = 6_000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("SERVER: Endian Testi için bekleniyor...");

            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());

            int header = in.readByte() & 0xFF;
            int cmd = in.readByte() & 0xFF;

            if(header != 0xAA) {
                System.out.println("SERVER: Geçersiz başlık alındı: " + String.format("0x%02X", header));
                return;
            }

            byte b1 = in.readByte();
            byte b2 = in.readByte();
            byte b3 = in.readByte();
            byte b4 = in.readByte();

            System.out.printf("Raw Bytes: 0x%02X 0x%02X 0x%02X 0x%02X%n", b1, b2, b3, b4);

            int correctedValue = ((b4 & 0xFF) << 24) | ((b3 & 0xFF) << 16) | ((b2 & 0xFF) << 8) | (b1 & 0xFF);
            System.out.println("Düzeltilmiş (Little Endian Logic) Değer: " + correctedValue);
            System.out.println("Hex Karşılığı: 0x" + Integer.toHexString(correctedValue).toUpperCase());

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}