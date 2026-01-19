public class ex_03 {
    public static void main(String[] args) {
        int limit = 10_000;
        String payload ="byte";

        long startA = System.nanoTime(); 
        String data = "";
        for (int i = 0; i < limit; i++) {
            data += payload;
        }
        long endA = System.nanoTime(); 
        double durationA = (endA - startA) / 1_000_000.0;
        System.out.println("String concatenation time: " + durationA + " ms");


        long startB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            sb.append(payload);
        }
        long endB = System.nanoTime();

        double durationB = (endB - startB) / 1_000_000.0;
        System.out.println("StringBuilder time: " + durationB + " ms");
        System.out.printf("Yöntem A (String +) Süresi : %.2f ms%n", durationA);
        System.out.printf("Yöntem B (StringBuilder) Süresi: %.2f ms%n", durationB);
        
        double fark = durationA / durationB;
        System.out.printf("Fark: StringBuilder %.2f kat daha hızlı!%n", fark);
    }
}

// String concatenation (String +) yöntemi, her eklemede yeni bir String nesnesi oluşturur ve bu da bellek tahsisi ve kopyalama işlemlerine neden olur. Bu nedenle, büyük döngülerde veya çok sayıda ekleme yapıldığında performans düşer.
// StringBuilder ise, dinamik olarak büyüyebilen bir karakter dizisi sağlar ve mevcut belleği yeniden kullanır. Bu, bellek tahsisi ve kopyalama işlemlerini azaltır, bu da performansı önemli ölçüde artırır.
// Özellikle büyük veri işleme senaryolarında, StringBuilder kullanımı önerilir çünkü bu yöntem daha verimli ve hızlıdır