import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TableNumber {

    public static boolean isRC(String s){

        int firstC = s.indexOf('C', 2);
        if (s.charAt(0)!='R' || firstC == -1) return false;
        for (int i = 1; i < firstC; i ++){
            if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0'))
                return false;
        }
        for (int i = firstC + 1; i < s.length(); i ++){
            if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0'))
                return false;
        }

        return true;
    }

    public static int CharToNum (String chars){
        int r = 0;
        for (char c : chars.toCharArray()){
            r = r * 26 + (c - 'A' + 1);
        }
        return r;
    }

    public static String NumToChar(int num, StringBuilder builder){
        char c;
        int t;
        while (num > 0){
            t = num % 26;
            c =(char)  (t + 'A' - 1);
            builder.insert(0, c);
            num = num / 26;
        }
        return builder.toString();
    }

    public static String RCToCN(String s, StringBuilder builder){
        int C = s.indexOf('C');
        int row = Integer.parseInt(s.substring(1, C));
        int col = Integer.parseInt(s.substring(C + 1));
        return NumToChar(col, builder) + row;
    }

    public static String CNToRC(String s, StringBuilder builder){
        int c = 1;
        char ch;
        for (; c < s.length(); c ++){
            ch = s.charAt(c);
            if (ch > '0' && ch <= '9' ) break;
        }
        int row = Integer.parseInt(s.substring(c));
        int col = CharToNum(s.substring(0, c));
        builder.append('R');
        builder.append(row);
        builder.append('C');
        builder.append(col);
        return builder.toString();
    }


    static String regx = "R\\d+C\\d+";

    public static boolean checkRCV2(String index){
        return index.matches(regx);
    }


    public static boolean checkRC(String index){
        if (index.charAt(0) == 'R'){
            int charsNum = 0, other = 0;
            char c;
            for (int i = 2; i < index.length(); i ++){
                c = index.charAt(i);
                if (c == 'C')   charsNum ++;
                else if (c < '0' || c > '9')    other ++;
            }
            if (charsNum == 1 && other == 0)    return true;
        }
        return false;
    }

    public static String transNum(int num, StringBuilder builder){
        builder.delete(0, builder.length());
        while (num > 0){
            builder.insert(0, (char) ((num - 1) % 26 + 'A'));
            num = (num - 1) / 26;
        }
        return builder.toString();
    }

    public static int transChar(String chars){
        int num = 0;
        for (int i = 0; i < chars.length(); i ++){
            num = num * 26 + (chars.charAt(i) - 'A' + 1);
        }
        return num;
    }

    public static String transRC(String s, StringBuilder builder, StringBuilder other){
        builder.delete(0, builder.length());
        int cPos = s.indexOf('C'), row = Integer.parseInt(s.substring(1, cPos)),
                col = Integer.parseInt(s.substring(cPos + 1));

        builder.append(transNum(col, other));
        builder.append(row);
        return builder.toString();
    }

    public static String transChNum(String s, StringBuilder builder){

        builder.delete(0, builder.length());

        int r = 0;
        char c ;
        for (; r < s.length(); r ++) {
            c = s.charAt(r);
            if (c >= '0' && c <='9' )
                break;
        }

        int col = transChar(s.substring(0, r));
        builder.append('R');
        builder.append(s.substring(r));
        builder.append('C');
        builder.append(col);
        return builder.toString();
    }


    public static void main(String[] args){


        StringBuilder builder = new StringBuilder();
        StringBuilder other = new StringBuilder();
        /*
        System.out.println(NumToChar(55, builder));
        builder.delete(0, builder.length());
        System.out.println(CharToNum("BC"));
        System.out.println(isRC("R2C3"));
        System.out.println(isRC("RC18"));

        System.out.println(RCToCN("R23C55", builder));
        builder.delete(0, builder.length());
        System.out.println(CNToRC("BC23", builder));
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        String[] inputs = new String[i];
        for (int j =0; j < i; j ++)
            inputs[j] = scanner.nextLine();
        scanner.close();



        String input;
        for (int j = 0; j < i;j ++){
            input = inputs[j];
            if (isRC(input)) System.out.println(RCToCN(input, builder));
            else System.out.println(CNToRC(input, builder));
            builder.delete(0, builder.length());
        }*/

/*
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[num];
        for (int i = 0; num > i; i++){
            strs[i] = scanner.nextLine().trim();
        }
        scanner.close();
        for (String s: strs) {
            if (checkRC(s)) {
                System.out.println( transRC(s, builder, other));
            }else {
                System.out.println(transChNum(s, builder));
            }
        }

        int i = 0;*/

        System.out.println(checkRCV2("RC89"));




        /*
        System.out.println(transNum(26, builder));
        System.out.println(transNum(27, builder));
        System.out.println(transNum(52, builder));
        System.out.println(transNum(53, builder));


        System.out.println(transChar("A"));
        System.out.println(transChar("AA"));
        System.out.println(transChar("Z"));
        System.out.println(transChar("AZ"));
        System.out.println(transChar("BA"));*/




    }

}
