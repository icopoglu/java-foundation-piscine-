import java.io.*;
import java.net.*;

public class LittleEndianDevice {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6_000;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("LE DEVICE: Server'a bağlandı.");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("LE DEVICE: 2500 Little-endian formatında veri gönderiliyor.");

            out.writeByte(0xAA);
            out.writeByte(0x01);
            out.writeByte(0xC4);
            out.writeByte(0x09);
            out.writeByte(0x00);
            out.writeByte(0x00);

            out.flush();
            System.out.println("LE DEVICE: Veri gönderildi.");
        }
        catch (IOException e) {
            e.printStackTrace();
        } 
        }
    }


