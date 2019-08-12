import java.util.LinkedList;

public class Combination {

    public static void combine(String string, int m){
        if (m > string.length() || m <= 0)
            throw new IllegalArgumentException("The order of combination number must be less than string's length");
        if (string == null)
            throw new IllegalArgumentException("base string can not be null!");

        char[] chars = string.toCharArray();
        LinkedList<Integer> l = new LinkedList<>();
        combine(chars, m, 0, l);
        //l.removeLast()
    }

    private static void combine(char[] chars, int m, int start, LinkedList<Integer> l){
        if (chars.length - start < m)
            return;
        if (0 == m){
            for (int i: l)
                System.out.print(chars[i]);
            System.out.print("\n");
        }else {
            l.add(start);
            combine(chars, m - 1, start + 1, l);
            l.removeLast();
            combine(chars, m, start + 1, l);
        }

    }

    public static void main(String[] args){
        String s = "abc";
        combine(s, 1);
        combine(s, 2);
        combine(s, 3);
    }


}
