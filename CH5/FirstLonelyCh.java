public class FirstLonelyCh {

    public static char find(String s){

        if (s == null || s.length() == 0)    return 0;
        int[] first = new int[26], times = new int[26];
        for (int i = 0; i < s.length(); i ++){
            int pos = s.charAt(i) - 'a';
            if (first[pos] == 0)    first[pos] = i;
            times[pos] = times[pos] + 1;
        }

        for (int i= 0; i < s.length(); i ++){
            int pos = s.charAt(i) - 'a';
            if (times[pos] == 1)    return s.charAt(i);
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(find("abdckdabck"));
        int s = 0;
        if (true || s ++ >0) System.out.println(s);
    }
}
