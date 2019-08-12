public class DigitSum {

    /**
     * get the sum of all digits in a positive integer
     * @param integer
     * @return
     */
    public static int getdigitsum(int integer){
        int s = 0;
        while (integer > 0){
            s += integer % 10;
            integer = integer / 10;
        }
        return s;
    }

    public static int getArrayDigitSum(int[] array){
        int s = 0;
        for (int i = 0; i < array.length; i ++){
            s += getdigitsum(array[i]);
        }
        return s;
    }
}
