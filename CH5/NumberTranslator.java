public class NumberTranslator {
    /**
     * translate number to strings with specific rules:
     * 0 - a, 1 - b, ... , 25 - z
     */

    public static int countTranslation(int n){
        int result = countTranslation(Integer.toString(n), "", 0);
        return result;
    }

    private static int countTranslation(String n, String toPrinter, int i){
        if (i >= n.length()){
            System.out.println(toPrinter);
            return 1;
        }

        int total = 0, t = 0;
        String s = "";
        for (int j = i; j < n.length(); j ++){
            s += n.charAt(j);
            t = Integer.parseInt(s);
            if (t <= 25)
                total += countTranslation(n, toPrinter + (char) (t + 'a'), j + 1);
            else
                break;
        }
        return total;
    }

    private static int countTranslationInt(int n){
        if (n == 0)     return 1;
        int total = 0, t = 0, i = 1;
        while (n != 0){
            t = t + (n % 10) * i;
            i *= 10;
            n = n / 10;
            if (t <= 25)
                total += countTranslationInt(n);
            else
                break;
        }
        return total;
    }


    private static int countTranslationIterative(int n){
        if (n < 0)     return  -1;
        char[] numbers = Integer.toString(n).toCharArray();
        int count = 0, l = numbers.length;
        int[] counts = new int[l];

        for (int i = l - 1; i >= 0 ; i--){
            if (i == l - 1)     count = 1;
            else                count = counts[i + 1];

            if (i < l - 1){
                int digit1 = numbers[i] - '0';
                int digit2 = numbers[i + 1] - '0';
                int c = digit1 * 10 + digit2;
                if (c > 9 && c < 26){
                    if (i < l - 2)
                        count += counts[i + 2];
                    else
                        count += 1;
                }
            }
            counts[i] = count;
        }
        return counts[0];

    }


    public static void main(String[] args){
        char x = 'a' + 25;
        System.out.println(x);
        char y = '1' - '0' + 'a';
        System.out.println(Integer.parseInt("0001"));

        System.out.println(countTranslation(12258));
        System.out.println(countTranslation(345));
        System.out.println("quantity of various translation: " +  countTranslationInt(345));
        System.out.println("quantity of various translation: " +  countTranslationInt(12258));
        System.out.println(countTranslationIterative(12258));
        System.out.println(Integer.MIN_VALUE >>31);
    }
}
