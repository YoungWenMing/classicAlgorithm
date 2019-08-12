import java.util.*;

public class Problem15 {

    public static int BinaryOne(int n){
        int x = 0;
        while (n != 0){
            n = n & (n - 1);
            x ++;
        }
        return x;
    }

    public static void main(String[] args){
        System.out.println(BinaryOne(-2));
        System.out.println(0x7fffffff);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toHexString(Integer.MIN_VALUE));



        HashMap<Integer, String> h = new HashMap<>();
        LinkedHashMap<Integer, String> l = new LinkedHashMap<>();


        l.put(2, "world!");
        l.put(0x172, "hello");
        l.put(1, "hello");

        l.put(1, "hello");
        h.put(2, "world");
        h.put(0x172, "hello");
        h.put(1, "hello");
        h.entrySet();
        for (Map.Entry i :h.entrySet())
            System.out.println(i);
        for (int i : h.keySet())
            System.out.println(i);

        for (Map.Entry i : l.entrySet())
            System.out.println(i);

        System.out.println(Objects.hashCode(h));
        System.out.println(h);
        System.out.println(0xffff >> 16);
        System.out.println(0xffff >>> 16);
    }

}
