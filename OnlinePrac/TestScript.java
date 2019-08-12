import java.util.Arrays;
import java.util.Scanner;


public class TestScript {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int AI[] = new int[total];
        int[] BI = new int[total];
        int[] dist = new int[total], aux = new int[total], auxA = new int[total], auxB = new int[total];

        for (int i = 0;i <total; i ++){
            AI[i] = scanner.nextInt();
        }

        for (int i = 0; i < total; i ++){
            BI[i] = scanner.nextInt();
            dist[i] = AI[i] - BI[i];
        }
        int[] temp;

        int window = 1;
        while (window < total ){
            for (int i = 0; i < total;  i += 2 * window){
                int start = i, mid = i + window,
                        end = Math.min(i + 2 * window, total );
                int j = mid, k = start;
                while (start < end){
                    if (j >= end) {
                        aux[start] = dist[k];
                        auxA[start] = AI[k];
                        auxB[start++] = BI[k++];
                    }
                    else if (k >= mid){
                        aux[start] = dist[j];
                        auxA[start] = AI[j];
                        auxB[start++] = BI[j++];
                    }
                    else if (dist[k] <= dist[j]){
                        aux[start] = dist[k];
                        auxA[start] = AI[k];
                        auxB[start++] = BI[k++];
                    }
                    else {
                        //count += (mid - i);
                        aux[start] = dist[j];
                        auxA[start] = AI[j];
                        auxB[start++] = BI[j++];
                    }
                }

            }
            window *= 2;
            temp = aux; aux = dist; dist = temp;
            temp = auxA; auxA = AI; AI = temp;
            temp = auxB; auxB = BI; BI = temp;
        }

        /*
        for (int i = total - 1; i >0; i --){
            for (int j = 0; j < i; j ++){
                if (dist[j] > dist[j + 1]){
                    exchange(dist, j, j + 1);
                    exchange(AI, j ,j + 1);
                    exchange(BI, j, j + 1);
                }
            }
        }*/

        double sum = 0;
        for (int i = total - 1; i >= total / 3 * 2; i --)
            sum += AI[i];
        for (int i = 0; i < total / 3; i ++)
            sum += BI[i];
        for (int i = total / 3; i < total / 3 * 2; i ++)
            sum += (AI[i] + BI[i]) / 2.0;

        System.out.println(Arrays.toString(AI));
        System.out.println(Arrays.toString(BI));
        System.out.println(Arrays.toString(dist));


        System.out.printf("%.2f", sum);


    }

    public static void exchange(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
