public class ex_04{
    public static byte calculateXorChecksum(byte[] data){
        byte checksum = 0;
        for(byte b : data){
            checksum ^= b;
        }
        return checksum;
    }

    public static int calculateCRC8(byte[] data){
        int crc = 0;
        int polinomial = 0x07;
        for(byte b : data){
            crc ^= b & 0xFF;
            for(int i = 0; i < 8; i++){
                if((crc & 0x80) != 0){
                    crc = (crc << 1) ^ polinomial;
                } else {
                    crc <<= 1;
                }
                crc &= 0xFF;
            }
        }
        return crc;
    }
    public static void main(String[] args){
        byte[] data = {(byte)0x9A, (byte)0xBC, (byte)0xDE, (byte)0xF0};

        byte xorChecksum = calculateXorChecksum(data);
        int crc8 = calculateCRC8(data);

        System.out.printf("XOR Checksum: 0x%02X%n", xorChecksum);
        System.out.printf("CRC-8: 0x%02X%n", crc8);
    }

}


// XOR checksum, verilerin basit bir hata tespit mekanizmasıdır ve genellikle düşük hata tespiti gereksinimleri olan uygulamalarda kullanılır. Hesaplaması hızlıdır ancak bazı hata türlerini tespit edemeyebilir.
// CRC-8 (Cyclic Redundancy Check), daha karmaşık bir hata tespit mekanizmasıdır ve daha yüksek hata tespiti yeteneğine sahiptir. Özellikle veri iletiminde ve depolamada yaygın olarak kullanılır.
// CRC-8, belirli bir polinom kullanarak verileri işler ve bu nedenle XOR checksum'a göre daha güvenilirdir. Ancak, hesaplaması XOR checksum'a göre daha yavaştır ve daha fazla işlem gücü gerektirir.
// Hangi yöntemin kullanılacağı, uygulamanın gereksinimlerine bağlıdır. Basit ve hızlı bir kontrol gerekiyorsa XOR checksum tercih edilebilir. Ancak, daha güvenilir bir hata tespiti gerekiyorsa CRC-8 daha uygun bir seçim olacaktır.