public class longestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();

        String head = strs[0];
        int i = 0, l = head.length(), num = strs.length;
        char c;
        while(i < l){
            c = head.charAt(i);
            for (int j = 1; j < num; j ++){
                if(i == strs[j].length() || strs[j].charAt(i) != c)  return builder.toString();
            }
            builder.append(c);
            i ++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"abstract", "abandon", "absolute"};
        System.out.println(longestCommonPrefix(strs));

    }

}
