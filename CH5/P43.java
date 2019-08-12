
/*
* to solve how many ones in the range from 0 to num, each one on any valid digit counts
* */

public class P43 {

    public static int count(int num){
        if (num < 10)   return num >= 1? 1 : 0;
        String number = Integer.toString(num);
        int digits = number.length(), next = Integer.parseInt(number.substring(1)),
                power = (int) Math.pow(10, digits - 1);

        int n = Math.min(power, num - power + 1) + (num / power) * (digits - 1) *((int) Math.pow(10, digits - 2));

        return n + count(next);

    }

    public static void main(String[] args) {
        System.out.println(count(99));
        System.out.println(count(1));
        System.out.println(count(999));
        System.out.println(count(998));
        System.out.println(count(991));
        System.out.println(count(21345));

    }

}
