public class IntegerPower {


    public static double power(double base, int exponent){
        if (base == 0)      return 0;
        if (exponent >= 0)  return purePositivePower(base, exponent);
        else                return 1 / purePositivePower(base,  - exponent);
    }

    /**
     * assume that exponent are positive, get the positive power
     * use bit calculation to get more efficient code
     * @param base
     * @param exponent
     * @return
     */
    static private double purePositivePower(double base, int exponent){
        if (exponent == 0)  return 1;
        double remain = purePositivePower(base * base, exponent >> 1);
        return (exponent & 1) == 0? remain : base * remain;
    }


}
