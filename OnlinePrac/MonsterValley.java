import java.util.*;

public class MonsterValley {

    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] powers = new long[N];
        int[] prices = new int[N];
        for (int i = 0; i < N; i ++)
            powers[i] = scanner.nextLong();
        for (int i = 0; i < N; i ++)
            prices[i] = scanner.nextInt();*/


        Random random = new Random();
        int N = random.nextInt(10);

        long[] powers = new long[N];
        int[] prices = new int[N];

        for (int i = 0; i < N; i ++)
            powers[i] = random.nextInt(1000);
        for (int i = 0; i < N; i ++)
            prices[i] = random.nextInt(2) + 1;

        powers = new long[]{85, 404, 1489, 2307, 3166, 3276};
        prices = new int[]{1, 2, 2, 2, 1, 2};


        PriorityQueue<Long> one = new PriorityQueue<>(N, new StrComparator());
        int total = calc(powers, prices, one);
        //PriorityQueue<Long> two = new PriorityQueue<>(N, new StrComparator());
        /*long oneM = 0, twoM = 0, cP;
        int total = prices[0], pri;
        long powerSum = powers[0];

        for (int i = 1; i < N; i ++){
            cP =powers[i];
            pri = prices[i];
            if (cP > powerSum){
                if  (pri == 2 && one.size() >= 2){
                    oneM = one.poll();
                    twoM = one.poll();
                    if (oneM + twoM > cP)
                        powerSum += (oneM + twoM);
                    else {
                        powerSum += cP;
                        one.add(oneM);
                        one.add(twoM);
                    }
                    total += 2;
                }
                else //if (pri == 1 || prices[i] == 2)
                {powerSum += cP;
                    total ++;}
            }
            else if (pri == 1)
                one.add(cP);
        }*/

        System.out.println(Arrays.toString(powers));
        System.out.println(Arrays.toString(prices));
        System.out.println(total);


    }

    static public int calc(long[] powers, int[] prices, PriorityQueue<Long> one){
        long oneM = 0, twoM = 0, cP;
        int total = prices[0], pri, N = powers.length;
        long powerSum = powers[0];

        for (int i = 1; i < N; i ++){
            cP =powers[i];
            pri = prices[i];
            if (cP > powerSum){
                if  (pri == 2 && one.size() >= 2){
                    oneM = one.poll();
                    twoM = one.poll();
                    if (oneM + twoM > cP)
                        powerSum += (oneM + twoM);
                    else {
                        powerSum += cP;
                        one.add(oneM);
                        one.add(twoM);
                    }
                    total += 2;
                }
                else //if (pri == 1 || prices[i] == 2)
                {powerSum += cP;
                    total += pri;}
            }
            else if (pri == 1)
                one.add(cP);
        }
        return total;
    }

    static class StrComparator implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {

            if (o1 > o2) return -1;
            else if (o1 < o2)   return 1;
            return 0;
        }
    }

}
