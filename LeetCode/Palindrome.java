public class Palindrome {

    public static String longestPalidrome(String s){
        if (s == null || s.length() == 0)   return "";
        int L = 0, R = 0, start = 0, end = 0, l = s.length(), i;
        char index = s.charAt(0), c;
        boolean flat = true;

        for (i = 1; i < l; i ++){
            c = s.charAt(i);
            /*
            * add new characters at the two side directly*/
            if (start > 0 && c == s.charAt( start - 1)){
                start --;
                end ++;
                if (flat && c != index)
                    flat = false;
            }else {
                // the palindrome consists of identical characters, it keep growing
                if (flat && s.charAt(end) == c){
                    end ++;
                }else {
                    // new start with one character only
                    start = end = i;
                    flat = true;
                    index = c;
                }
            }

            if (end - start > R - L){
                R = end;
                L = start;
            }
        }
        return s.substring(L, R + 1);
    }


    public static String dpSolution(String s){
        int l = s.length();
        if (l == 0) return "";
        boolean[][] dp = new boolean[l][l];
        for (int i = 0; i < l; i ++)
            dp[i][i] = true;

        int L = 0, R = 0, len = 1;
        for (int i = 1; i < l; i ++) {
            if ((dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i)) && len == 1){
                L = i - 1;
                R = i;
                len = 2;
            }
        }

        for (int k = 2; k < l; k ++){
            for (int i = 0, j = k; j < l ; i++, j ++) {
                if ((dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) && k + 1 > len){
                    L = i;
                    R = j;
                    len = k + 1;
                }
            }
        }
        return s.substring(L, R + 1);

    }


    public static void main(String[] args) {
        String s = "abb";
        System.out.println(dpSolution(s));

        s = "abbcbb";
        System.out.println(dpSolution(s));

        s = "abcddcba";
        System.out.println(dpSolution(s));

        s = "bananas";
        System.out.println(longestPalidrome(s));

        System.out.println(dpSolution(s));
    }

}
