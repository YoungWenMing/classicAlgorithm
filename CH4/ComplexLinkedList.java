import java.util.LinkedList;

public class ComplexLinkedList {

    static class Node {
        public int value;
        public Node next, sibling;

        public Node(int v, Node n, Node s){
            value = v;
            next = n;
            sibling = s;
        }

        public String toString(){

            return "value " + value + " next " + next.value + " sibling " + sibling.value;
        }
    }

    public static Node copyList(Node n){
        copyOriginalNode(n);
        copySiblingLink(n);
        return deattach(n);
    }

    /**
     * create duplicates for every node, and make these
     * duplicates original nodes' next neighbor, the sibling
     * links are not concerned here
     * @param n
     */
    private static void copyOriginalNode(Node n){
        Node handler = n;
        while (handler != null){
            Node x = new Node(handler.value, handler.next, null);
            handler.next = x;
            handler = x.next;
        }
    }

    /**
     * copy sibling links
     * @param n
     */
    private static void copySiblingLink(Node n){
        //if (n == null)      return;
        Node handler = n;
        while (handler != null){
            Node x = handler.sibling;
            if (x != null)      handler.next.sibling = x.next;
            handler = handler.next.next;
        }
    }


    private static Node deattach(Node n){
        if (n == null)      return null;
        Node r = n.next, handler = n;
        while (handler != null){
            Node successor = handler.next;
            handler.next = successor.next;
            if (successor.next != null)
                successor.next = successor.next.next;
            handler = handler.next;

        }
        return r;
    }

    public static void main(String[] args){
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        Node n3 = new Node(3, null, null);
        Node n4 = new Node(4, null, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        n1.sibling = n4;
        n2.sibling = n1;
        n3.sibling = n2;
        n4.sibling = n3;

        Node m1 = copyList(n1);
        Node m2 = m1.next;
        Node m3 = m2.next;
        Node m4 = m3.next;

        System.out.println(m1);
        System.out.println(n1);

        Node x = copyList(null);
        System.out.println(x);

        Node t = new Node(1, null, null);
        Node r = new Node(2, null, null);
        t.next = r;
        t.sibling = r;
        r.sibling = t;

        Node s = copyList(t);
        Node q = s.sibling;
        System.out.println(s);
        LinkedList<Integer> l = new LinkedList<>();
    }

}
