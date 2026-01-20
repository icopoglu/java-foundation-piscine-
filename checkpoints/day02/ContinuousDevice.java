import java.io.*;
import java.net.*;
import java.util.Random;



public class ContinuousDevice {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6_000;


        Random random = new Random();

        try (Socket socket = new Socket(host,port)){
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("DEVICE: Bağlandı! Sürekli veri basılıyor...");

            for (int i = 1; i <= 100; i++) {
                int tempValue = 2_000 + random.nextInt(1_000);

                out.writeByte(0xAA);
                out.writeByte(0x01);
                out.writeInt(tempValue);
                out.flush();

                System.out.println("DEVICE: Paket " + i + " gönderildi (" + tempValue + ")");
                
                Thread.sleep(2_000);
            }
        }
        catch (Exception e){
            System.out.println("DEVICE Bağlantı Koptu.");
        }
    }
}