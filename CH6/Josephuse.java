public class Josephuse {

    private static class Node{
        public int value;
        public Node next;

        public Node(int v, Node next){
            value = v;
            this.next = next;
        }
    }

    public static Node assembleCircle(int n){
        Node start = new Node(0, null),
                pre = start, post;
        for (int i = 1;i < n; i ++){
            post = new Node(i, null);
            pre.next = post;
            pre = post;
        }
        pre.next = start;
        return start;
    }

    public static int find(int n, int m){
        Node start = new Node(0, null),
                pre = start, post;
        for (int i = 1;i < n; i ++){
            post = new Node(i, null);
            pre.next = post;
            pre = post;
        }
        pre.next = start;
        while (start.next != start){
            for (int i = 0; i < m - 1; i ++){
                start = start.next;
                pre = pre.next;
            }
            pre.next = start.next;
            start.next = null;
            start = pre.next;
        }
        return start.value;
    }


    public static int findV2(int n, int m){
        if (n < 1 || m < 1)     return -1;
        int last = 0;
        for (int i = 2; i <= n; i ++){
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args){
        int array[] = new int[]{0,1,2,3,4};
        System.out.println(find(5, 3));
        System.out.println(findV2(5,3));
        System.out.println(findV2(4000, 997));

    }

}
