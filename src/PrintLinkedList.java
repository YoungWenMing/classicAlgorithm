import java.util.LinkedList;
import java.util.Stack;

public class PrintLinkedList {

    public static void main(String[] args){
        /*
        LinkedListS<Integer> linkedList = new LinkedListS<>();
        for (int i = 0; i < 10; i ++)
            linkedList.addItem(i);
        linkedList.printStartToEnd();
        LinkedListS.Node n = linkedList.getNode(0);
        linkedList.deleteNode(n);
        linkedList.printEndToStart();

        linkedList.addItem(10);
        linkedList.addItem(10);
        linkedList.addItem(10);
        linkedList.printStartToEnd();
        linkedList.deleteDuplicate();
        linkedList.printStartToEnd();

        LinkedListS<Integer> l = new LinkedListS<>();
        l.addItem(1);
        l.addItem(1);
        l.addItem(1);
        l.addItem(new Integer[]{2,3,4,5,5,6,7,8, 8, 8});
        l.printStartToEnd();

        int k = 20;

        System.out.printf("the last %d th item is %s", k, l.getLastNthNode(k));

        l = new LinkedListS<>();
        System.out.printf("middle item is %s\n", l.getMiddleNode());
        l.addItem(1);
        System.out.printf("middle item is %s\n", l.getMiddleNode());
        l.addItem(2);
        System.out.printf("middle item is %s\n", l.getMiddleNode());
        l.addItem(3);
        System.out.printf("middle item is %s\n", l.getMiddleNode());

        LinkedListS.Node n = new LinkedListS.Node(22, null);
        LinkedListS.Node o = new LinkedListS.Node(33, null);
        LinkedListS.Node p = new LinkedListS.Node(44, null);
        n.next = o;
        o.next = p;
        p.next = n;
        LinkedListS linkedList = new LinkedListS();
        for (int i = 0; i < 1; i ++)
            linkedList.addItem(i);
        System.out.printf("linkedList has a ring with %d nodes.\n", linkedList.countNodeInRing());
        linkedList.addNode(n);
        System.out.printf("linkedList has a ring with %d nodes.", linkedList.countNodeInRing());
        LinkedListS l = new LinkedListS();
        l.addNode(n);
        System.out.printf("linkedList has a ring with %d nodes.", l.countNodeInRing());
        System.out.printf("find the start of this ring: %s", l.findRingInlet());*/

        LinkedListS l = new LinkedListS();
        l.addItem(new int[]{2,3,4, 5,6,7,8});
        l.printStartToEnd();

        LinkedListS m = new LinkedListS();
        m.addItem(new int[]{0, 1, 5, 8, 8, 9});
        m.printStartToEnd();

        LinkedListS.merge(l, m).printStartToEnd();

        l = new LinkedListS();
        l.addItem(new int[]{2,3,4,6,7,8});
        LinkedListS.merge(l, null).printStartToEnd();

        l = new LinkedListS();
        l.addItem(new int[]{2,3,4,6,7,8});

        m = new LinkedListS();
        m.addItem(new int[]{10, 11, 12, 13});
        LinkedListS.merge(l, m).printStartToEnd();

        l = new LinkedListS();
        l.addItem(new int[]{2,3,4,6,7,8});
        l.printStartToEnd();
        l.reverseListV();
        l.printStartToEnd();

        l = new LinkedListS();
        l.reverseListV();

    }
}

