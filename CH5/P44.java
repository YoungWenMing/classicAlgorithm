import java.util.Random;

public class P44 {

    public static void main(String[] args){
        for (int i = 0; i < 51; i ++){
            System.out.print(i);
        }
        System.out.println();
        Random random = new Random(47);
        System.out.println( getNthDigit(10));
        int j;
        for (int i = 0; i < 10; i ++)
            System.out.println(( j = random.nextInt(90)) + " -- " + getNthDigit(j));

    }

    public static char getNthDigit(int n){
        if (n == 0)     return 0;
        int digits = 0, nums = 0, base = 0, offset = n;
        do{

            digits ++;
            offset -= nums;
            base = base == 0? 1: base * 10;
            nums = 9 * base * digits;

        }while (offset > nums);

        int number = (offset - 1) / digits + base;
        return Integer.toString(number).charAt((offset - 1) % digits);

    }
}
