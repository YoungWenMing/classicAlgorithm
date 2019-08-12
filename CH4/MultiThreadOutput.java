import java.io.IOException;

public class MultiThreadOutput {

    public static void main(String[] args){
        int number = 20, times = 1000;
        long interval = 20;

        try {
            for (int i = number; i > 0; i--) {
                Thread t = new CountTime(interval, times);
                t.start();
            }
        }catch (IOException e){
            System.err.print(e);
        }
        //System.exit(0);
    }

}
