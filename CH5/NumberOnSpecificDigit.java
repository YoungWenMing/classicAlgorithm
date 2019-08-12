public class NumberOnSpecificDigit {

    public static char FindNthNumber(int n){
        if (n < 10)     return Integer.toString(n).charAt(0);
        int i = 1, t = 10, digits = 10;
        while (true){
            i ++;
            n = n - digits;
            digits = i * t * 9;     // quantity of integers with i digits, two digits number: 10 - 99, 90
            if  (n < digits)
                return Integer.toString(t + (n / i)).charAt(n % i);
        }
    }


    public static void main(String[] args){
        System.out.println(FindNthNumber(0));
        System.out.println(FindNthNumber(10));
        System.out.println(FindNthNumber(19));
    }

}
