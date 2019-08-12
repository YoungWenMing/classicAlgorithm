public class ReplaceWhiteSpace {

    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        String s = " hello world, i  love you! ";

        String h = s.concat("yeah");
        System.out.println(h);

        String s1 = replace(s, ' ', "%20");
        //assert s1.equals("hello%20world,%20i%20love%20you!");
        System.out.println(s1);
    }

    public static String replace(String s, char stuff, String newStuff){
        //get the length of new string
        int len = 0, factor = newStuff.length();
        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == stuff)   len += factor;
            else                        len ++;
        }
        StringBuilder stringBuilder = new StringBuilder(len);
        //build new string by splitting the old one
        int end = 0, l = s.length();
        while (end < l){
            if (s.charAt(end) == stuff)
                stringBuilder.append(newStuff);
            else
                stringBuilder.append(s.charAt(end));
            end++;
        }
        return stringBuilder.toString();
    }

}
