public class NumberString {

    public static boolean isNumber(String s){
        if (s == null || s.length() == 0)   return false;
        // flag is an indicator of whether entered a state successfully


        int p = 0, l = s.length(), state = 0;
        // append last character do not affect correctness
        // but it can lower complexity of bound case
        s = s + s.charAt(l - 1);

        // initialization
        if (s.charAt(p) == '+' || s.charAt(p) == '-')   p++;

        while (p < l){
            char ch = s.charAt(p++);
            if (state == 0){
                if (isDigit(ch))                state = 1;
                else if (ch == '.')             state = 2;
                else                            return false;
            }else if (state == 1){
                if (ch == 'e' || ch == 'E')     state = 3;
                else if (ch == '.')             state = 2;
                else if (!isDigit(ch))          return false;
            }else if (state == 2){
                if ((ch == 'e' || ch == 'E') && isDigit(s.charAt(p - 2)))
                    state = 3;
                else if(!isDigit(ch))           return false;
            }else {
                boolean b1 = ch == '+' || ch == '-';
                boolean b2 = (s.charAt(p - 2) == 'e' || s.charAt(p -2) == 'E');
                if (!(isDigit(ch) || (b1 && b2) ))        return false;
            }
        }
        return true;
    }

    private static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }


    public static boolean isValidNumber(String s){
        if (s == null || s.length() == 0)   return false;
        int pos = scanSign(s, 0), l = s.length(), t = 0;
        pos = scanUnsignInteger(s, pos);

        if (pos == l)  return true;


        /*if we meet a point, go through every integer
        * until a dot or an 'e' show up*/
        if (s.charAt(pos) == '.'){
            // dot is at the last digit
            if (pos == l - 1)   return false;
            t = scanUnsignInteger(s, pos + 1);
            // t == pos + 1 means t did not move forward
            if (t == pos + 1)   return false;
            if (t == l)         return true;
            pos = t;
        }
        if (s.charAt(pos) == 'e' || s.charAt(pos) == 'E'){
            // e is at the last digit
            if (pos == l - 1)   return false;
            pos = scanSign(s, pos + 1);
            t = scanUnsignInteger(s, pos + 1);
            // not a valid integer following 'e'
            if (t == pos + 1)   return false;
        }
        return t == l;
    }

    private static int scanUnsignInteger(String s, int start){
        int i = start;
        while (i < s.length()){
            if (! isDigit(s.charAt(i)))
                break;
            i ++;
        }
        return i;
    }

    private static int scanSign(String s, int start){
        if (s.charAt(start) == '+' || s.charAt(start) == '-')
            return ++start;
        return start;
    }

    /*
    private static int scanInteger(String s, int start){
        int i = start;
        if (s.charAt(i) == '+' || s.charAt(i) == '-')   i++;

    }*/

}
