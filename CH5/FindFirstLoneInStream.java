import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FindFirstLoneInStream {

    static int i =0;
    static volatile FileInputStream f;
    static volatile boolean goOnScan = true;

    public static int record(InputStream is, int[] pos){
        int p = 0;
        try {
            p = is.read();
        }catch (IOException e){
            System.err.println(e);
            System.exit(1);
        }
        if (p == -1)    return -1;
        System.out.println("we got " + (char) p);

        synchronized (pos){
            if (pos[p] >= 0)    pos[p] = -2;
            else                pos[p] = i ++;
        }
        return p;
    }

    public static char scanFirst(int[] pos){
        int m = -1, i = 0, j = 0;
        synchronized (pos){
            for (; i < pos.length; i ++){
                if (pos[i] < 0)    continue;
                if (m == -1) {
                    m = pos[i];
                    j = i;
                }
                else if (m > pos[i]){
                    m = pos[i];
                    j = i;
                }
            }
        }
        if (j == 0)    return 0;
        return (char) j;
    }

    public static void main(String[] args){


        int[] chs = new int[256];
        for (int i = 0; i < 256; i ++){
            chs[i] = -1;
        }
        try {
            f = new FileInputStream("/home/wenming/cslab/interviewProblems/CH4/foo.txt");
        }catch (IOException e){
            System.err.println(e);
            System.exit(1);
        }
        Thread recorder = new Thread(){
            @Override
            public void run(){
                int p = 0;

                try {
                    sleep(1);
                }catch (InterruptedException e){
                    System.err.println(e);
                }

                while (p != -1){
                    p = record(f, chs);
                }
                goOnScan = false;

                System.out.println("record ends");

                try {
                    f.close();
                }catch (IOException e){

                }
            }
        };

        Thread scanner = new Thread(){
            @Override
            public void run() {
                char c;
                while (goOnScan){
                    c = scanFirst(chs);
                    if (c == 0)
                        System.out.println("every character has companions...");
                    else
                        System.out.println("current first lonely character is: "+ c);
                }
                System.out.println("stopping scan");
            }
        };

        recorder.start();

        scanner.start();
    }

}
