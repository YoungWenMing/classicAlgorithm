public class OneToN {

    public static int SumSolution1(int n){
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    public static int SumSolution2(int n){
        int sum = n;
        boolean b = (n > 0) && ((sum = SumSolution2(n - 1)) > 0);
        return sum;
    }
}
