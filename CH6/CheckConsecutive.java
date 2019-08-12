public class CheckConsecutive {

    public static boolean check(int[] cards){
        if (cards == null || cards.length < 2)
            return true;
        int l = cards.length;
        SelectionSort.sort(cards);

        int zeros = 0, current;
        for (int i = 0; i < l - 1;i++){
            current = cards[i];
            if (current == 0) {
                zeros++;
                continue;
            }
            if (current == cards[i + 1])
                return false;
            zeros -= (cards[i + 1] - current -1);
            if (zeros < 0)  return false;
        }
        return true;
    }


    public static void main(String[] args){
        int[] cards = new int[]{0,4, 5, 2, 3};
        System.out.println(check(cards));

        cards = new  int[]{9, 13, 11, 10,2};
        System.out.println(check(cards));
    }
}
