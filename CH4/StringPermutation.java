import java.util.Arrays;

public class StringPermutation {

    public static void permutation(String string){
        if (string == null)     return;
        char chars[] = string.toCharArray();
        permutation(chars, 0);
    }

    public static void permutation(int[] ints){
        if (ints == null)     return;
        //char chars[] = string.toCharArray();
        permutation(ints, 0);
    }

    private static void permutation(char[] chars, int start){

        // when we reach the end of this string
        if (start == chars.length - 1){
            for (char c : chars)
                System.out.print(c);
            System.out.print("\n");
        }else {
            for (int i = start; i < chars.length; i ++){
                SwitchItems(chars, start, i);
                permutation(chars, start + 1);
                SwitchItems(chars, start, i);
            }
        }
    }

    private static void permutation(int[] chars, int start){

        // when we reach the end of this string
        if (start == chars.length - 1){
            if (isCorrect(chars))
                System.out.println(Arrays.toString(chars));
        }else {
            for (int i = start; i < chars.length; i ++){
                SwitchItems(chars, start, i);
                permutation(chars, start + 1);
                SwitchItems(chars, start, i);
            }
        }
    }

    private static boolean isCorrect(int[] ints){
        int s1 = ints[0] + ints[1] + ints[2] + ints[3];
        int s2 = ints[0] + ints[1] + ints[4] + ints[5];
        int s3 = ints[0] + ints[4] + ints[7] + ints[3];
        int s4 = ints[2] + ints[6] + ints[7] + ints[3];
        int s5 = ints[2] + ints[6] + ints[5] + ints[1];
        int s6 = ints[4] + ints[6] + ints[7] + ints[5];
        return s1 == s6 && s2 == s4 && s3 == s5;
    }


    private static void SwitchItems(char[] chars, int p1, int p2){
        char temp = chars[p1];
        chars[p1] = chars[p2];
        chars[p2] = temp;
    }

    private static void SwitchItems(int[] chars, int p1, int p2){
        int temp = chars[p1];
        chars[p1] = chars[p2];
        chars[p2] = temp;
    }

    public static void main(String[] args){
        String s = "ab";
        permutation(s);

        s = "";
        //permutation(s);

        s = "abc";
        permutation(s);

        s = "abcd";
        //permutation(s);
    }

}
