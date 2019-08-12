import java.util.Stack;

public class LinkedListS{

    public Node first;


    static public class Node{
        int value;
        Node next;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        public String toString(){
            return value + " ";
        }
    }

    public void addItem(int value){
        if (first == null)
            first = new Node(value, null);
        else {
            Node x = first;
            while (x.next != null)
                x = x.next;
            x.next = new Node(value, null);
        }
    }

    public void addItem(int[] values){
        for (int i = 0; i < values.length; i++)
            this.addItem(values[i]);
    }

    public void addNode(Node n) {
        if (first == null || countNodeInRing() != 0){
            first = n;
            return;
        }
        Node node = first;
        while (node.next != null)
            node = node.next;
        node.next = n;
    }

    public void printEndToStart(){
        Stack<Integer> stack = new Stack<>();
        Node n = first;
        while (n != null){
            stack.push(n.value);
            n = n.next;
        }
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.print("\n");
    }

    public void printStartToEnd(){
        Node x = first;
        while (x != null){
            System.out.print(x.value + " ");
            x = x.next;
        }
        System.out.print("\n");
    }

    public Node getNode(int i){
        Node x = first;
        while (x != null){
            if (x.value == i)   return x;
            x = x.next;
        }
        return null;
    }

    /**
     * assume that it is certainly that n is in this linkedlist
     * @param n
     */
    public void deleteNode(Node n){
        if (n == null)
            return;
        if (n == first)
            first = n.next;
        else if (n.next == null){
            Node p = first;
            while (p.next != n)
                p = p.next;
            p.next = null;
        }else {
            n.value = n.next.value;
            n.next = n.next.next;
        }
    }

    public void deleteDuplicate(){
        Node prenode = first;
        while (prenode.next != null){
            // send a sentinel to forward
            Node sentinel = prenode.next;
            /**
             * when the linkedlist do not begin with duplicate items
             * we need to check the maximum sequence of duplicates items
             * for example, 1, 2, 3, 3, 3, 4, 5, 5
             * first, if we do not reach the end (sentinel.next != null)
             *      we must keep this loop running
             * within this loop:
             *      case one: our sentinel entered the duplicates sub-sequence
             *          and is still in it (sentinel.value = sentinel.next.value), simply move sentinel forwardly
             *      case two: sentinel do not enter the area, we just forward prenode and sentinel
             *          simultaneously
             *      case three: sentinel are about to leave the special with very one step, what we should do
             *          is discard the sub-sequence between sentinel's successor and prenode
             * outside this loop:
             *      items following prenode can be null as well as a duplicates sequence, so we must discard everything
             *      behind temporal prenode
             *
             * when the linkedlist starts with duplicates stuff, we need to find the next different item and reset 'first'
             */
            if (prenode.value != sentinel.value) {
                while (sentinel.next != null) {
                    if (sentinel.value == sentinel.next.value)
                        sentinel = sentinel.next;
                    else if (prenode.next == sentinel) {
                        prenode = sentinel;
                        sentinel = sentinel.next;
                    }else {
                        prenode.next = sentinel.next;
                        prenode = prenode.next;
                        sentinel = prenode.next;
                    }
                }
                if (prenode.next != sentinel)
                    prenode.next = null;
                return;
            }
            else {

                while (sentinel != null && sentinel.value == prenode.value)
                    sentinel = sentinel.next;
                first = sentinel;
                prenode = sentinel;
            }
        }
    }

    public void deleteDup(){
        Node pre = new Node(0, first);
        Node start = first, end;
        while (start != null){
            if (start.next != null && start.value == start.next.value){
                end = start.next;
                while (end != null && end.value == start.value)
                    end = end.next;
                if (start == first){
                    first = end;
                    pre.next = first;
                }else
                    pre.next = end;
                start = end;
            }else {
                start = start.next;
                pre = pre.next;
            }
        }
    }


    public Node getLastNthNode(int k){
        if (first == null)  return null;
        Node goal = null, sentinel = first;
        while (sentinel != null){
            if (goal == null)       goal = --k == 0? first:goal;
            else                    goal = goal.next;
            sentinel = sentinel.next;
        }
        return goal;
    }

    public Node getMiddleNode(){
        if (first == null)      return null;
        Node p1 = first, p2 = first;
        while (p1.next != null && p1.next.next != null){
            p2 = p2.next;
            p1 = p1.next.next;
        }
        return p2;
    }

    public int countNodeInRing(){
        if (first == null)      return 0;
        int n = 0;
        Node p1 = first, p2 = first;
        while (p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                n++;
                break;
            }
        }
        if (n != 0){
            while (p2.next != p1){
                p2 = p2.next;
                n ++;
            }
        }
        return n;
    }

    /**
     * if there is a ring in this linked list
     * return the inlet node
     * idea:    count quantity of nodes in this ring
     *          and then dispatch two sentinel to go through
     *          this ring. the first sentinel goes n steps before
     *          the second one sets off. these two sentinels
     *          will eventually meet each other at the inlet
     * @return
     */
    public Node findRingInlet(){
        int n = countNodeInRing();
        if (n == 0) return null;
        Node p1 = null, p2 = first;
        while (p1 != p2){
            if (p1 != null)     p1 = p1.next;
            if (--n == 0)       p1 = first;
            p2 = p2.next;
        }
        return p1;
    }


    public void reverseList(){
        if (first == null)  return;

        Node newHead, newTail, walker = first;
        newHead = new Node(first.value, first);
        newTail = newHead;
        walker = walker.next;
        while (walker != null){
            Node x = newHead;
            newHead = new Node(walker.value, x);
            walker = walker.next;
        }
        newTail.next = null;
        first = newHead;
    }

    public void reverseListV(){
        //if (first == null)  return;

        Node before = null, current = first, after = first;
        /**
         * current and after point to a same node
         * after every single round
         */
        while (current!= null){
            after = after.next;
            current.next = before;
            before = current;
            current = after;
        }

        first = before;
    }


    /**
     * for two sorted linkedlists' heads, merge two list and
     * keep the sort
     * @param L2
     * @param L1
     * @return
     */
    public static LinkedListS merge(LinkedListS L1, LinkedListS L2){
        if (L1 == null || L2 == null)
            return L1 == null? L2 : L1;

        Node n1 = L1.first, n2 = L2.first;
        Node base, part, result;
        if (n1.value >= n2.value){
            base = n2;
            part = n1;
        }else{
            base = n1;
            part = n2;
        }

        result = base;

        while (base.next != null){
            if (base.next.value >= part.value){
                Node temp = part;
                part = part.next;
                temp.next = base.next;
                base.next = temp;
            }
            if (part == null)    break;
            base = base.next;
        }
        if (part != null)   base.next = part;

        LinkedListS s = new LinkedListS();
        s.first = result;
        return s;
    }


    public static void main(String[] args){
        LinkedListS l = new LinkedListS();
        l.addItem(new int[]{1,2, 3, 3, 4, 5,6});
        l.deleteDup();
        l.printStartToEnd();

        l = new LinkedListS();
        l.addItem(new int[]{0, 0, 1,1,2, 3, 3, 4, 5,6, 6, 6});
        l.deleteDup();
        l.printStartToEnd();

        l = new LinkedListS();
        l.deleteDup();
    }


}