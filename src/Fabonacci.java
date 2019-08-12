import java.util.HashMap;


public class Fabonacci {

    private HashMap<Long, Long> dict;

    public Fabonacci(){
        dict = new HashMap<>();
    }


    /**
     * get the nth number of fabonacci sequence
     * with simple recursion
     * @param n
     * @return
     */
    public static long fabonacci(long n){
        if (n ==0 || n == 1)
            return n;
        else
            return fabonacci(n - 1) + fabonacci(n - 2);
    }

    /**
     * get the nth number of fabonacci sequence
     * with a container
     * @param n
     * @return
     */
    public long fabonacciS(long n){
        if (dict.containsKey(n))
            return dict.get(n);
        if (n == 0|| n == 1)
            dict.put(n, n);
        else
            dict.put(n, fabonacciS(n));
        return dict.get(n);
    }


    public static void main(String[] args){
        /*
        int a = 10;
        System.out.printf("the %d th number of fabonacci sequence: %d\n", a, fabonacci(a));
        Fabonacci f = new Fabonacci();
        long t1 = System.currentTimeMillis();
        System.out.printf("the %d th number of fabonacci sequence: %d\n", 50, Fabonacci.fabonacci(50));
        long t2 = System.currentTimeMillis();
        System.out.printf("simple recursion takes time: %d", t2 - t1);
        t1 = System.currentTimeMillis();
        System.out.printf("the %d th number of fabonacci sequence: %d\n", 50, f.fabonacciS(50));
        t2 = System.currentTimeMillis();
        System.out.printf("recursion with container takes time: %d", t2 - t1);
        */

        long x = fabonacci(40);
        System.out.println(x);
    }

}
