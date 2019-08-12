public class LongestSubSeqNoDup {

    public static String find(String s){
        int len = 0, start = 0, end = 0, L = s.length();
        int[] characters;
        int i = 0, j = 0;
        while (j < L){
            characters = new int[26];
            for (i = j; j < L;j++){
                int x = s.charAt(j) - 'a';
                if (characters[x] == 1) break;
                else                    characters[x] = 1;
            }
            if (j - i > len){
                end = j;    start = i;      len = j - i;
            }
        }
        return s.substring(start, end);
    }

    public static String findV2(String s){
        int len = 0, start = 0, e = 0, L = s.length();
        int[] characters = new int[26];

        for (int k = 0; k < 26; k ++)
            characters[k] = -1;

        int i = 0, j = 0;
        while (j < L){
            for (i = j; j < L; j ++){
                int x = s.charAt(j) - 'a';
                if (characters[x] >= i && j != i){
                    characters[x] = j;
                    break;
                }
                characters[x] = j;
            }
            if (j - i > len){
                start = i; e = j; len = j - i;
            }
        }
        return s.substring(start, e);
    }

    public static void main(String[] args){
        String s = "arabcacfr";
        System.out.println(find(s));
        System.out.println(findV2(s));
    }

}
