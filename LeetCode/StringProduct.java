public class StringProduct {

    public static String transform(String num1, String num2){

        if (num1 == "0" || num2 == "0")     return "0";
        int i, j, k, l1, l2;
        int x, y, t;

        int[] digits = new int[(l1 = num1.length()) + (l2 = num2.length())];
        for (i = l1 - 1; i >= 0; i --){
            x = num1.charAt(i) - '0';
            k = l1 - i - 1;
            for (j = l2 - 1; j >= 0; j --){
                y = num2.charAt(j) - '0';
                digits[k] += x * y;
                if ((t = digits[k]) >= 10){
                    digits[k] = t % 10;
                    digits[k + 1] += t / 10;
                }
                k ++;
            }
        }



        StringBuilder builder = new StringBuilder();
        boolean begin = false;

        for (i = l1 + l2 - 1; i >= 0;i --) {
            if (digits[i] != 0)  begin = true;
            if(begin) builder.append(digits[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args){
        String num1 = "123", num2 = "45690";
        System.out.println(transform("0", "0"));
    }

}
