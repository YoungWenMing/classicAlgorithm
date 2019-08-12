import java.io.*;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;

public class IOExperiment {


    public static void print() throws IOException{
        OutputStream out = System.out;
        out.write('a');
        out.flush();
    }

    public static void main(String[] args) throws IOException,
            FileNotFoundException{
        /*
        int b = 0;
        byte[] bytes ;
        BufferedReader is;// = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw;
        String inputLine;
        InputStream fi;
        OutputStream fo;
       */
        try {
            print();
            /*
            //bytes = new InputStreamReader(System.in).read();
            //System.out.println("Read this data : " +  bytes.length);
            for (byte i : bytes)
                System.out.println((char) i);
            while ((inputLine = is.readLine() )!= null) {
                System.out.println("input stream got: " + inputLine);
            }
            int x[] = new int[3];
            for (int i = 0; i < 3; i ++) {
                x[i] = is.read();
            }
            is.close();
            System.out.println(Arrays.toString(x));*/

            //fi = new FileInputStream("/home/wenming/cslab/interviewProblems/CH4/foo.txt");
            //is = new BufferedReader(new FileReader("/home/wenming/cslab/interviewProblems/CH4/foo.txt"));
            //fo = new FileOutputStream("foo2.txt");
            //pw = new PrintWriter(new FileWriter("/home/wenming/cslab/interviewProblems/CH4/foo2.txt"));
            //int i;
            /*while ((i = fi.read()) != -1){
                System.out.println((char) i);
            }
            fi.close();
            //is.close();
            //pw.close();
            //fi.close();
            //fo.close();*/
        }catch (Exception e){
            System.out.println("Caught "+ e);
        }finally {

        }

/*
        Thread t0 = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread t0 is running!");
                int[] readin = new int[10];
                try{
                    for (int i = 0 ; i < 10; i ++){
                        int x = is.read();
                        readin[i] = x;
                        if (x == 10)    break;
                    }
                    sleep(10);
                    for (int i : readin)
                        System.out.println("t0 got " + i);

                    System.out.print("\n t0 is ending");
                }catch (Exception e){
                    System.err.println("t0 sleep was interrupted!");
                }

            }
        };
*/
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread t1 is running!");
                Console cons;
                try{
                    sleep(100);
                    //System.console().writer().write("0123456789\n");
                    //cons.writer().write();
                    /*
                    for (int i = 0; i < 10; i ++){
                        System.out.print(i);
                    }
                    System.out.print('\n');*/
                    sleep(10);
                    System.out.print("\n t1 is ending");
                }catch (Exception e){
                    System.err.println(e);
                }
            }
        };


    }

}
