public class Maxprofit {

    public static int calc(int[] prices){
        if (prices == null || prices.length < 2)
            return 0;
        int lowest = prices[0], profit = prices[1] - prices[0],temp;
        for (int i = 1; i < prices.length;i ++){
            temp = prices[i];
            if (temp - lowest > profit)     profit = temp - lowest;
            if (temp < lowest)      lowest = temp;
        }
        return profit;
    }

    public static void main(String[] args){
        int prices[] = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(calc(prices));

        prices = new int[]{1, 2};
        System.out.println(calc(prices));
    }
}
