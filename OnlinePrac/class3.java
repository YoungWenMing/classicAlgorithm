public class class3 {

    public static void main(String[] args) {
        System.out.println(test());
        Boolean flag = false;
        Integer a = 1;

        int i = 3;

        String result = new String();
        switch (i) {
            case 1:
                result = result + "him ";
                break;
            case 2:
                result = result + "her ";
            case 3:
                result = result + "it ";
                break;
            default:
                result = result + "me ";}
        System.out.println(result);

    }

    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return temp = addOne(temp);
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println("In finally block " + temp);
        }
    }

    static private int addOne(int i){
        System.out.println("adding one");
        return i + 1;
    }
}
