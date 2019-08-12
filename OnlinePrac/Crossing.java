public class Crossing {

    private static String[] width = new String[11];

    static {
        StringBuilder sb = new StringBuilder();
        int i = 1, k = 1, j = 1;
        width[0] = "";
        for (;j < 11; j ++) {
            for (; i <= k; i++)
                sb.append(' ');
            k = k * 3;
            width[j] = sb.toString();
        }
    }



    public static void printOrderN(String whites, String gap, int n, int times){
        if (n == 1){
            System.out.print(whites);
            for (int i = 0; i < times; i ++){
                System.out.print(gap);
                System.out.print('o');
                System.out.print(gap);
            }
            System.out.print(whites);
        }
        else {

            String nGap = width[n - 2];
            printOrderN(whites + gap, nGap, n - 1, times);
            System.out.println();
            printOrderN(whites, nGap, n - 1, times * 3);
            System.out.println();
            printOrderN(whites + gap, nGap, n - 1, times);


            /*
            StringBuilder b = new StringBuilder();
            for (int i =0; i < Math.pow(3, n - 2); i ++)
                b.append(' ');

            String t = null, bs = b.toString();

            if (n == 2) {
                t = " ";
                bs = "";
            }
            else            t = "";
            b = null;

            printOrderN(whites + bs, t,n - 1, times);
            System.out.println();
            printOrderN(whites, s, n - 1, times * 3);
            System.out.println();
            printOrderN(whites + bs, t,n - 1, times);*/

        }
    }

    public static void main(String[] args) {
        printOrderN("", width[3-1], 3, 1);
    }

}
