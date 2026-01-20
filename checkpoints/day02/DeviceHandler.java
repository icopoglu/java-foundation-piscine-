import java.io.*;
import java.net.*;


public class DeviceHandler implements Runnable {

    private Socket socket;
    private int deviceId;

    public DeviceHandler(Socket socket, int deviceId){

        this.socket = socket;
        this.deviceId = deviceId;
    }
    @Override

    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println("COMMAND CENTER: Cihaz #" + deviceId + "bağlandı.(" + threadName + ")");

        try (DataInputStream in = new DataInputStream(socket.getInputStream())) {

            while (true){
                byte header = in.readByte();
                int unsignedHeader = header & 0xFF;

                if(unsignedHeader != 0xAA){
                    System.err.println("Cihaz #" + deviceId + "Hatalı Header (Sync Lost)!");
                    break;
                }

                byte cmd = in.readByte();
                int value = in.readInt();

                System.out.printf("[Cihaz #%d] Komut: 0x%02X, Değer: %d%n", deviceId, cmd, value);
            }
        }
        catch (EOFException e){
            System.out.println("COMMAND CENTER: Cihaz #" + deviceId + " bağlantıyı kesti.");
        }
        catch (IOException e){
            System.out.println("Hata (Cihaz #" + deviceId +"):" + e.getMessage());
        }
    }

}