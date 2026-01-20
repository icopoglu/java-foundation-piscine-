import java.io.*;
import java.net.*;

public class FakeDevice{
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6000;

        try (Socket socket = new Socket (host, port)){
            System.out.println("DEVICE: Server'a bağlandı.");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            int sensorValue = 25_00;

            System.out.println("DEVICE: Sensör değeri gönderiliyor: " + sensorValue);
            System.out.println("Header: 0xAA, CMD: 0x01, Val: " + sensorValue);

            out.writeByte(0xAA);
            out.writeByte(0x01);

            out.writeInt(sensorValue);

            System.out.println("DEVICE: Sensör değeri gönderildi.");
        }
        catch (IOException e) {
            System.out.println("DEVICE: Hata oluştu - " + e.getMessage());
        }
    }
}