public class PrintOneToNDigit {

    private int[] number;
    private final int  n;

    public PrintOneToNDigit(int n){
        if (n <= 0)
            throw new IllegalArgumentException("digits must be larger than 0");
        number = new int[n];

        this.n = n;
    }

    private boolean addOne(int d){
        if (d > n)
            return false;
        if (number[n - d] == 9){
            number[n - d] = 0;
            return addOne(d + 1);
        }else {
            number[n - d] ++;
            return true;
        }

    }

    private void print(){
        boolean b = false;
        for (int i = 0; i < n; i ++) {
            if (number[i] != 0) b = true;
            if (b);              System.out.print(number[i]);
        }
        System.out.print("\n");
    }

    public void printAll(){
        while (addOne(1))
            print();
    }


    public static void PrintOneToMaxNdigit(int n){
        if (n <= 0) return;
        char[] numbers = new char[n];
        printRecursive(numbers, 0);
    }

    private static void printRecursive(char[] chars, int k){
        if (k == chars.length)  printNumber(chars);
        else {
            for (int i = 0; i <10; i ++){
                chars[k] =(char) (i +'0');
                printRecursive(chars, k + 1);
            }
        }
    }

    private static void printNumber(char[] chars){
        boolean begin = false;
        for (int i = 0 ; i < chars.length;i ++){
            if (!begin && chars[i] != '0')  begin = true;
            if (begin) System.out.print(chars[i]);
        }
        System.out.println();
    }


    public static void main(String[] args){
        long t1 = System.currentTimeMillis();
        PrintOneToNDigit p = new PrintOneToNDigit(4);
        p.printAll();
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        PrintOneToMaxNdigit(4);
        long t4 = System.currentTimeMillis();

        System.out.printf("time cost: %d, %d", t2 - t1, t4- t3);
    }
}
