class Counter{
    int count = 0;
}

public class CounterTest {
    static void reset (Counter x){
        x = new Counter();
    }

    static void increment(Counter x) {
        x.count++; 
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.count = 5;

        System.out.println("Başlangıç: " + c.count);

        increment(c);
        System.out.println("Increment Sonrası: " + c.count);
        reset(c);
        System.out.println("Reset Sonrası: " + c.count); 
    }
}

// Başlangıç: 5
// Increment Sonrası: 6
// Reset Sonrası: 6
// Bu sonuç, Java'nın parametre geçiş mekanizmasıyla ilgilidir. Java, tüm parametreleri "değer ile geçiş" (pass-by-value) olarak işler. Bu, bir nesne referansı bile olsa, referansın kendisinin bir kopyasının metoda geçirildiği anlamına gelir.
// increment metodu, Counter nesnesinin referansını alır ve bu referans üzerinden count değerini artırır. Bu nedenle, main metodundaki c nesnesinin count değeri artar.
// Ancak, reset metodu farklıdır. reset metoduna geçirilen x parametresi, main metodundaki c referansının bir kopyasıdır. reset metodu içinde x'e yeni bir Counter nesnesi atanır, ancak bu atama sadece x'in kopyasını etkiler. main metodundaki c referansı hala orijinal Counter nesnesini işaret eder ve bu nedenle count değeri değişmeden kalır.