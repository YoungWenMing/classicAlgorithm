public class bitCalculator {

    public static int countBinaryOne(int n){
        int  i = 0, count = 0, flag = 1;
        while (i < 32){
            if ((n & flag)  > 0)
                count ++;
            flag = flag << 1;
            i ++;
        }
        return count;
    }

    public static int countBinaryOneEasy(int n){
        int count = 0;
        while (n != 0){
            n = n & (n - 1);
            count ++;
        }
        return count;
    }

}
