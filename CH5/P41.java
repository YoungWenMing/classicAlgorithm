import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class P41 {


    public static int FindMiddleInStream(DataInputStream in) throws IOException {

        PriorityQueue<Integer> big = new PriorityQueue<>(new BiggerComparator()),
                small = new PriorityQueue<>();
        boolean odd = true;
        int temp, k;
        while ((temp = in.readInt()) != -1){
            if (odd){
                if (!big.isEmpty()){
                    k = small.peek();
                    if (temp > k){
                        k = temp;
                        temp = small.poll();
                        small.add(k);
                    }
                }
                big.add(temp);
            }else {
                if (!small.isEmpty()){
                    k = big.peek();
                    if (temp < k){
                        k = temp;
                        temp = big.poll();
                        big.add(k);
                    }
                }
                small.add(temp);
            }
            odd = !odd;
        }
        return odd? (big.peek() + small.peek()) / 2: big.peek();
    }


    public static void main(String[] args) throws IOException{

        Random random = new Random();

        File file = new File("test.dat");
        DataOutputStream dout = new DataOutputStream(new FileOutputStream(file));
        dout.writeInt(256);
        int t;
        for (int i = 0; i < 14; i ++){
            System.out.print((t = random.nextInt(1000)) + " ");
            dout.writeInt(t);
        }

        dout.writeInt(-1);
        dout.close();

        DataInputStream din = new DataInputStream(new FileInputStream(new File("test.dat")));
        System.out.println(FindMiddleInStream(din));
        din.close();

        InputStream in = System.in;

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader inReader = new InputStreamReader(System.in);
        //DataInputStream dataReader = new DataInputStream(System.in);
        //int k = dataReader.readInt();
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println(k);
        k = scanner.nextInt();
        System.out.println(k);
        k = scanner.nextInt();
        System.out.println(k);

        scanner.close();
    }

}

class BiggerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2)    return -1;
        if (o1 < o2)    return 1;
        return 0;
    }
}