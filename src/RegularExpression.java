public class RegularExpression {

    private String reg;

    public RegularExpression(String reg){
        this.reg = reg;
    }

    public boolean match(String string){
        if (string == null)
            throw new IllegalArgumentException("string must not start with *!");
        if (reg.length() == 0 && string.length() == 0)
            return true;

        int pp = 0, ps = 0, lengthOfReg = reg.length(), lengthOfString = string.length();
        while (pp < lengthOfReg && ps < lengthOfString){
            // when entering the star state, we need to care about under what condition
            // can we leave the state and what should be done when this happen
            if (pp < lengthOfReg - 1 && reg.charAt(pp + 1) == '*'){
                if (reg.charAt(pp) != string.charAt(ps)) {
                    pp = pp + 2;
                    continue;
                }
            }else {
                if (reg.charAt(pp) != '.' && reg.charAt(pp) != string.charAt(ps))
                    return false;
                pp ++;
            }
            // no matter what case we get, pointer of string keep forwarding
            // but pointer of pattern does not keep pace with its counterpart of string
            ps ++;
        }
        if (pp == lengthOfReg && ps == lengthOfString)  return true;
        return false;
    }

    public static boolean match(String pat, String str){
        if (pat == null || str == null)     throw new IllegalArgumentException();
        for (int i = 1; i < pat.length(); i ++)
            if (pat.charAt(i-1) == '*' && pat.charAt(i) == '*')
                throw new IllegalArgumentException("illegal regular expression with two consecutive *");
        int p1 = pat.charAt(0) == '*' ? 1:0;
        int p2 = 0, l1 = pat.length(), l2 = str.length();
        char cp, cs;
        /*
        while (p1< l1 && p2 < l2){
            cp = pat.charAt(p1);
            cs = str.charAt(p2);
            if (cp == '.'){
                if (p1 + 1 < l1 && pat.charAt(p1 + 1) != '*'|| p1 == l1 - 1)
                    p1 ++;
                p2 ++;
            }else {
                /*either there is any other character but a star after p1, or p1 points to the last character*/
         /*       if ((p1 + 1 < l1 && pat.charAt(p1 + 1) != '*') || p1 == l1 - 1){
                    if (cp != cs)   return false;
                    p1 ++;
                    p2 ++;
                }else{
                    // we get a star '*' here
                    if (cp != cs)   p1 += 2;
                    else            p2 ++;
                }
            }
        }*/


        while (p1< l1 && p2 < l2){
            cp = pat.charAt(p1);
            cs = str.charAt(p2);
            if ((p1 + 1 < l1 && pat.charAt(p1 + 1) != '*') || (p1 == l1 - 1)){
                if (cp != cs && cp != '.')      return false;
                else                            p1 ++;
            }else {
                /*
                if (p1 == l1 - 1){
                    // when reaching the last character of the pattern
                    if (cp != cs && cp != '.')      return false;
                    p1 ++;
                }else {*/
                    // we do get a '*'
                    // p2 meets the last character
                if (p2 == l2 - 1)
                    p1 += 2;
                if (cp != cs && cp != '.'){
                    p1 += 2;
                    continue;
                }
            }
            p2 ++;
        }
        return (p2 == l2 && p1 == l1);


        /*
        if (p2 == l2 && (p1 == l1 || (p1 == l1 - 2 && pat.charAt(l1 - 1) == '*')))
            return true;
        return false;*/
    }

}
