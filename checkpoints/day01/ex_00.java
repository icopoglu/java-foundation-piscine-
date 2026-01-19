public class ex_00 {
    public static void main (String[] args){
        int limit = 10000000;

        long startPrimitive = System.nanoTime();
        int sumPrimitive = 0; 
        for (int i = 0; i < limit; i++) {
            sumPrimitive += i;
        }
        long endPrimitive = System.nanoTime();
        long durationPrimitive = endPrimitive - startPrimitive;


        long startWrapper = System.nanoTime();
        Integer sumWrapper = 0; 
        for (int i = 0; i < limit; i++) {
            sumWrapper += i; 
        }
        long endWrapper = System.nanoTime();
        long durationWrapper = endWrapper - startWrapper;

        System.out.println("--- Maliyet Analizi ---");
        System.out.println("Primitive (int) Süresi : " + durationPrimitive / 1_000_000.0 + " ms");
        System.out.println("Wrapper (Integer) Süresi: " + durationWrapper / 1_000_000.0 + " ms");
        
        double farkKat = (double) durationWrapper / durationPrimitive;
        System.out.printf("Fark: Integer kullanımı %.2f kat daha yavaş!%n", farkKat);
    }
}

// Primitive tipler (int, char, boolean, vb.) doğrudan değerleri depolar ve bellekte daha az yer kaplarlar. Bu nedenle, işlemler daha hızlı gerçekleşir.
// Wrapper sınıflar (Integer, Character, Boolean, vb.) ise nesne olarak temsil edilir ve bu nesnelerin oluşturulması, çöp toplama ve ek bellek yönetimi gerektirir. Bu ek yük, performansın düşmesine neden olur.
// Özellikle büyük döngülerde veya yoğun hesaplamalarda, primitive tiplerin kullanımı belirgin bir performans avantajı sağlar.
// Bu nedenle, performans kritik uygulamalarda mümkün olduğunca primitive tiplerin kullanılması önerilir.
// Evet, Java'da sayıları daha okunabilir hale getirmek için alt çizgi (_) kullanabilirsiniz. Örneğin, 10 milyon sayısını 10_000_000 şeklinde tanımlayabilirsiniz. Bu, sayının değerini etkilemez, sadece kodun okunabilirliğini artırır. Aynı şekilde, 1_000 gibi daha küçük sayılar için de alt çizgi kullanabilirsiniz.