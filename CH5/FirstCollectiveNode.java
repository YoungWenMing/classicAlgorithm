public class FirstCollectiveNode {

    public static class Node{
        int value;
        public Node next;

        public Node(int v, Node n){
            value = v; next = n;
        }
    }

    public static Node find(Node x, Node y){
        if (x == null || y == null)
            throw new IllegalArgumentException();

        int xl = getLinkLength(x), yl = getLinkLength(y), d =0;
        Node longlink, shortlink;
        if (xl > yl){
            shortlink = y;
            longlink = x;
            d = xl - yl;
        }else {
            shortlink = x;
            longlink = y;
            d = yl - xl;
        }

        for (;d > 0; d --)  longlink = longlink.next;
        while (shortlink !=null && longlink != null){
            if (shortlink == longlink)  return shortlink;
            shortlink = shortlink.next;
            longlink = longlink.next;
        }
        return null;

    }

    private static int getLinkLength(Node n){
        int l = 0;
        while (n != null){
            l ++;
            n = n.next;
        }
        return l;
    }

    public static void main(String[] args){
        Node m = new Node(1, null);
        Node n = new Node(2, m);
        Node o = new Node(3, n);
        Node p = new Node(4, o);
        Node q = new Node(5, n);

        System.out.println(find(q, p).value);
        System.out.println(find(q, q).value);
    }
}
