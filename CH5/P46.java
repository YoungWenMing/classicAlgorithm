
/**
 * to translate a sequence of number into English chars
 * return the total number of possible ways
 * i can apply dynamic programming tactic
 * */

public class P46 {

    public static int count(int number){

        String s = Integer.toString(number);
        int l = s.length(), nums[] = new int[l + 1], dou;
        nums[0] = 1;
        for (int i = 0; i < l; i ++){
            nums[i + 1] = nums[i];
            if (i > 0){
                /*
                * if the current number along with the previous one
                * can be translated
                * */
                dou = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
                if (dou <= 25 && dou >= 10) nums[i+1] += nums[i -1];
            }
        }
        return nums[l];
    }


    public static void main(String[] args) {
        System.out.println(count(12258));
        System.out.println(count(122));
    }

}
