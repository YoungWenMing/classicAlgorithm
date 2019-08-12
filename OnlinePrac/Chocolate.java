import java.util.Scanner;

/*
* 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力

输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000)。

输出描述:
输出一个数表示小Q第一天最多能吃多少块巧克力。

输入例子1:
3 7

输出例子1:
4
*
*
* */


public class Chocolate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(), N = scanner.nextInt();   // M --- days, N --- chocolates
        int min = 1, max = N, mid, sum, daily;
        while (min <= max){
            daily = mid = (min + max) / 2;
            sum = 0;
            for (int i = 0; i < M; i ++){
                sum += daily;
                daily = (daily & 1) == 0 ? daily / 2: daily / 2 + 1;
            }
            if (sum == N){
                max = mid;
                break;
            }
            else if (sum < N){
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }


}
