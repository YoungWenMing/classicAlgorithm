public class CountOne {

    public static int getLength(int a){
        return ("" + a).length();
    }

    public static int count(int a){
        int l = getLength(a);
        if (l <= 0 || a == 0)     return 0;
        else if (l == 1 && a  != 0)   return 1;
        int highest =(int) Math.pow(10, l - 1);
        int rest = a % highest;
        int f = a / highest;
        int result;
        // we calculate combination number here
        // when highest digit is beyond 1, it has a whole segment of number with highest
        // digit as 1, otherwise the part was left to rest part
        if (f == 1)
            result = (highest / 10) * (l - 1) + f;
        else
            result = (highest / 10) * (l - 1) * f + highest;
        return result + count(rest);
    }


    public static void main(String[] args){
        System.out.println(count(9999));
        System.out.println(count(9));
        System.out.println(count(10));

    }

}
