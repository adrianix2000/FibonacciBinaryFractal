import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Main.Run();
    }

    private static boolean isPrime(Long number) {
        if(number == 2) return true;
        if(number < 2 || number%2 == 0) return false;

        for(int i=3; i<=Math.sqrt(number); i+=2) {
            if(number%i == 0)
                return false;
        }
        return true;
    }

    public static void Run() {
        Fib f = Fib.getInstance();

        //zad1(f);

        List<Long> nodes = LongStream.range(1,41).mapToObj(i->f.generate(i)).toList();

        // zad2 nodes.stream().filter(n->isPrime(n)).forEach(System.out::println);

        List<String> binaryNodes = nodes.stream().map(Long::toBinaryString).toList();

        String last = binaryNodes.get(binaryNodes.size()-1);
        List<String> binaryNodesTemp = binaryNodes
                .stream().map(s->String.format("%"+last.length()+"s", s).replace(' ', '0'))
                        .toList();


        //zad4(binaryNodes);

        fraktal(binaryNodesTemp);
    }

    private static void zad1(Fib f) {
        System.out.println("10: " + f.generate(10L));
        System.out.println("20: " + f.generate(20L));
        System.out.println("30: " + f.generate(30L));
        System.out.println("40: " + f.generate(40L));
    }

    private static void zad4(List<String> binaryNodes) {
        binaryNodes.stream().filter(b->b.replaceAll("[0]", "").length()==6)
                .forEach(System.out::println);
    }

    private static void fraktal(List<String> binaryNodes) {
        MainFrame mf = new MainFrame(binaryNodes);
        mf.setVisible(true);
    }
}
