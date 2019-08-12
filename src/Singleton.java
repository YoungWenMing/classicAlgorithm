public class Singleton {

    private static Singleton obj;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (obj == null)
            obj = new Singleton();
        return obj;
    }

    public static void main(String[] args){
        /**
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("s1 with address " + s1);
        System.out.println("s2 with address " + s2);*/

        for (int i = 0;i < 100; i ++){
            new Thread(){
                public void run(){
                    Thread.yield();
                    System.out.println("Thread "  + " with Singleton of id " + Singleton.getInstance());
                }
            }.start();
        }

    }

}




class Singleton2 {
    private static Singleton2 obj;

    private Singleton2(){

    }

    public static synchronized Singleton2 getInstance(){
        if (obj == null)
            obj = new Singleton2();
        return obj;
    }
}

class Singleton3 {

    /*
    * do not take this notorious method, it probably does not work well
    * */
    private static Singleton3 obj;

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        if (obj == null)
            synchronized (Singleton3.class) {
                if (obj == null)
                    obj = new Singleton3();
            }
        return obj;
    }
}

class Singleton4{
    private static Singleton4 obj = new Singleton4();

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        return obj;
    }
}

class Singleton5{
    private static Singleton5 obj = null;
    private static class singletonHolder{
        private final static Singleton5 instance = new Singleton5();
    }

    /**
     * static fields will be initialized once the class is called for
     * the first time, on matter whether its constructor or some static fields
     * are requested.
     * @return
     */
    public static Singleton5 getInstance() {
        return singletonHolder.instance;
    }
}

