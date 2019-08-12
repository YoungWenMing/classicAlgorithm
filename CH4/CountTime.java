import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CountTime extends Thread {

    private static final String fileDirectory =
            "/home/wenming/cslab/interviewProblems/output/";

    private static int count = 0;
    private final int taskId = count ++;

    private long interval;

    private PrintWriter pw;
    private int times;


    public CountTime(long interval, int times) throws IOException {
        this.interval = interval;
        this.times = times;
        pw = new PrintWriter(new FileWriter(fileDirectory + "count" + taskId + ".txt"));
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i ++) {
            try {
                long t1 = System.currentTimeMillis();
                sleep(interval);
                long t2 = System.currentTimeMillis();
                pw.write(t2 - t1 + "\n");
            } catch (InterruptedException e) {
                interrupt();
                System.err.print(taskId + " is interrupted when sleeping : " + e);
            }

        }
        pw.write("this is count for thread: " + taskId);
        pw.close();

    }
}
