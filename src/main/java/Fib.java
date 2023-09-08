import java.util.*;

public class Fib {
    private List<Long> nodes;
    private static Fib instance;
    private Fib() {
        nodes = new ArrayList<>();
        nodes.add(1L);
    }

    public static Fib getInstance() {
        return instance == null ? new Fib() : instance;
    }
    public Long generate(Long n) {
        if (n<=2) return 1L;

        if(nodes.size()<n-1)
            nodes.add(generate(n-1));
        if(nodes.size()<n-2)
            nodes.add(generate(n-2));

        return nodes.get(n.intValue()-2) + nodes.get(n.intValue()-3);
    }
}
