public class BitAddition {

    public static int add(int n, int m){
        int forward = (n & m)<< 1;
        int sum = n ^ m;
        while (forward != 0){
            int temp = sum ^ forward;
            forward = (sum & forward) << 1;
            sum = temp;
        }
        return sum;
    }



    public static void main(String[] args){
        System.out.println(add(7,6));

        // switch without extra space
        int a = 1, b = 2;
        System.out.println("before switch: " + a + " " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("after switch: " + a+ " " + b);


        a = 100;
        b = 24;
        System.out.println("before switch: " + a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println("after switch: " + a + " " + b);
    }

}
