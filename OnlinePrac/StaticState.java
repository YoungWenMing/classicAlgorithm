public class StaticState extends class2 {

    static {
        System.out.print("static state is init\n");
    }

    public static void main(String[] args) {
        System.out.println(StaticState.abc);
    }

}

class class1{

    public static int a = 1;

    static {
        System.out.print("class1 is init\n");
    }

}